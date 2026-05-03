package tests;

import model.*;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TaxCalculatorTests {
    @Test
    void selectStateCalculatorValidStatesTest() {
        TaxManager manager = new TaxManager();

        assertTrue(manager.selectStateCalculator("CA") instanceof CaliforniaTaxCalculator);
        assertTrue(manager.selectStateCalculator("IA") instanceof IowaTaxCalculator);
        assertTrue(manager.selectStateCalculator("TX") instanceof TexasTaxCalculator);
    }

    @Test
    void calculateTaxForIowaTest() {
        TaxManager manager = new TaxManager();
        TaxPayer payer = new TaxPayer(100000, "single", "IA");

        double tax = manager.calculateTaxFor(payer);

        assertEquals(3900, tax, 0.01);
    }

    @Test
    void calculateTaxForTexasTest() {
        TaxManager manager = new TaxManager();
        TaxPayer payer = new TaxPayer(100000, "married", "TX");

        double tax = manager.calculateTaxFor(payer);

        assertEquals(0.0, tax);
    }

    @Test
    void getTaxableIncomeSingleTest() {
        TaxCalculator calc = new TaxCalculator() {
            @Override
            public double calculateTax(TaxPayer taxPayer) {
                return 0;
            }
        };
        TaxPayer payer = new TaxPayer(50000, "single", "IA");

        double taxable = calc.getTaxableIncome(payer);

        assertEquals(45000.0, taxable);
    }

    @Test
    void getTaxableIncomeMarriedTest() {
        TaxCalculator calc = new TaxCalculator() {
            @Override
            public double calculateTax(TaxPayer taxPayer) {
                return 0;
            }
        };
        TaxPayer payer = new TaxPayer(50000, "married", "IA");

        double taxable = calc.getTaxableIncome(payer);

        assertEquals(40000.0, taxable);
    }

    @Test
    void iowaTaxCalculationZeroIncomeTest() {
        IowaTaxCalculator calc = new IowaTaxCalculator();
        TaxPayer payer = new TaxPayer(0, "single", "IA");

        double tax = calc.calculateTax(payer);

        assertEquals(0.0, tax);
    }

    @Test
    void texasTaxAlwaysZeroTest() {
        TexasTaxCalculator calc = new TexasTaxCalculator();
        TaxPayer payer = new TaxPayer(999999, "married", "TX");

        double tax = calc.calculateTax(payer);

        assertEquals(0.0, tax);
    }

    @Test
    void californiaTaxRateSingleTest() {
        double rate = CaliforniaTaxCalculator.calculateTaxRate(9000, "single");
        assertEquals(0.01, rate);
    }

    @Test
    void californiaTaxRateMarriedTest() {
        double rate = CaliforniaTaxCalculator.calculateTaxRate(20000, "married");
        assertEquals(0.02, rate);
    }

    @Test
    void californiaTaxCalculationNoNegativeTaxTest() {
        CaliforniaTaxCalculator calc = new CaliforniaTaxCalculator();
        TaxPayer payer = new TaxPayer(1000, "single", "CA");

        double tax = calc.calculateTax(payer);

        assertTrue(tax >= 0.0);
    }
}


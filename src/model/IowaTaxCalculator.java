package model;

public class IowaTaxCalculator extends TaxCalculator {

    @Override
    public double getTaxableIncome(TaxPayer taxPayer) {
        return taxPayer.getIncome();
    }

    @Override
    public double calculateTax(TaxPayer taxPayer) {
        final double IOWA_TAX_RATE = 0.039;

        double taxableIncome = getTaxableIncome(taxPayer);
        double tax = taxableIncome * IOWA_TAX_RATE;

        System.out.println("Iowa flat tax rate: 3.9%");
        System.out.printf("Taxable income: $%.2f%n", taxableIncome);

        return tax;

        // https://www.taxformcalculator.com/iowa/tax-tables/2026.html used for source
    }
}

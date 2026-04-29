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

        return tax;

        // https://www.taxformcalculator.com/iowa/tax-tables/2026.html used for source
    }
}

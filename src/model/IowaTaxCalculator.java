package model;

public class IowaTaxCalculator extends TaxCalculator {

    @Override
    // Uses full income as taxable income (no deductions applied in Iowa calculation)
    // TaxPayer --> double
    public double getTaxableIncome(TaxPayer taxPayer) {
        return taxPayer.getIncome();
    }

    @Override
    // Calculates Iowa state tax using a flat tax rate
    // TaxPayer --> double
    public double calculateTax(TaxPayer taxPayer) {
        final double IOWA_TAX_RATE = 0.039;

        double taxableIncome = getTaxableIncome(taxPayer);
        double tax = taxableIncome * IOWA_TAX_RATE;

        return tax;

        // https://www.taxformcalculator.com/iowa/tax-tables/2026.html used for source
    }
}

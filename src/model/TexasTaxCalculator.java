package model;

public class TexasTaxCalculator extends TaxCalculator {
    @Override
    // Uses full income as taxable income (Texas has no deductions applied here)
    // TaxPayer --> double
    public double getTaxableIncome(TaxPayer taxPayer) {
        return taxPayer.getIncome();
    }

    @Override
    // Calculates Texas state tax (always zero due to no state income tax)
    // TaxPayer --> double
    public double calculateTax(TaxPayer taxPayer) {
        double taxableIncome = getTaxableIncome(taxPayer);

        return 0;

        // https://www.taxformcalculator.com/texas/tax-tables/2026.html#brackets used for source
    }
}

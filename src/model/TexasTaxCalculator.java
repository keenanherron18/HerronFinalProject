package model;

public class TexasTaxCalculator extends TaxCalculator {
    @Override
    public double getTaxableIncome(TaxPayer taxPayer) {
        return taxPayer.getIncome();
    }

    @Override
    public double calculateTax(TaxPayer taxPayer) {
        double taxableIncome = getTaxableIncome(taxPayer);

        return 0;

        // https://www.taxformcalculator.com/texas/tax-tables/2026.html#brackets used for source
    }
}

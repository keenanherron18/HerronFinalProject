package model;

public class TexasTaxCalculator extends TaxCalculator {
    @Override
    public double getTaxableIncome(TaxPayer taxPayer) {
        return taxPayer.getIncome();
    }

    @Override
    public double calculateTax(TaxPayer taxPayer) {
        double taxableIncome = getTaxableIncome(taxPayer);

        System.out.println("Texas has no state income tax.");
        System.out.printf("Taxable income: $%.2f%n", taxableIncome);

        return 0;

        // https://www.taxformcalculator.com/texas/tax-tables/2026.html#brackets used for source
    }
}

package model;

public class TaxManager {
    // Selects the correct tax calculator based on the state entered by the user
    // String --> TaxCalculator
    public TaxCalculator selectStateCalculator(String state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        } else if (state.equalsIgnoreCase("CA")) {
            return new CaliforniaTaxCalculator();
        } else if (state.equalsIgnoreCase("IA")) {
            return new IowaTaxCalculator();
        } else if (state.equalsIgnoreCase("TX")) {
            return new TexasTaxCalculator();
        } else {
            throw new IllegalArgumentException("Invalid state entered");
        }
    }

    // Calculates the final tax owed for a given taxpayer using the appropriate state calculator
    // TaxPayer --> double
    public double calculateTaxFor(TaxPayer taxPayer) {
        TaxCalculator calculator = selectStateCalculator(taxPayer.getState());
        return calculator.calculateTax(taxPayer);
    }
}

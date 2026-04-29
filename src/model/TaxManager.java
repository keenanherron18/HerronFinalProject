package model;

public class TaxManager {
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

    public double calculateTaxFor(TaxPayer taxPayer) {
        TaxCalculator calculator = selectStateCalculator(taxPayer.getState());
        return calculator.calculateTax(taxPayer);
    }
}

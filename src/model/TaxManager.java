package model;

public class TaxManager {
    public TaxCalculator selectState(String state) {
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        } else if (state.equalsIgnoreCase("CA")) {
            return new CaliforniaTaxCalculator();
        } else if (state.equalsIgnoreCase("IA")) {
            return new IowaTaxCalculator();
        } else if (state.equalsIgnoreCase("TX")) {
            return new TexasTaxCalculator();
        } else {
            return null;
        }
    }

    public double calculateTaxFor(TaxPayer taxPayer) {
        TaxCalculator calculator = selectState(taxPayer.getState());
        return calculator.calculateTax(taxPayer);
    }
}

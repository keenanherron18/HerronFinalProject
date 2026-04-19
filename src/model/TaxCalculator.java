package model;

public abstract class TaxCalculator {
    public double getTaxableIncome(TaxPayer taxPayer) {
        double income = taxPayer.getIncome();
        final double SINGLE_DEDUCTION = 5000;
        final double MARRIED_DEDUCTION = 10000;

        double taxableIncome;

        if (taxPayer.getStatus().equalsIgnoreCase("single")) {
            taxableIncome = Math.max(0, income - SINGLE_DEDUCTION);
        } else {
            taxableIncome = Math.max(0, income - MARRIED_DEDUCTION);
        }

        return taxableIncome;
    }

    public abstract double calculateTax(TaxPayer taxPayer);
}

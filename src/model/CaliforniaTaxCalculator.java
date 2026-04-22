package model;

import java.text.DecimalFormat;
import java.util.Random;

public class CaliforniaTaxCalculator extends TaxCalculator {
    // This method generates a random tax credit amount for a unique twist
    // double --> double
    public static double applyCredit(double tax) {
        Random randomCredit = new Random();
        final double MIN_CREDIT = 100;
        final double CREDIT_RANGE = 900;

        double credit = MIN_CREDIT + (CREDIT_RANGE * randomCredit.nextDouble());
        System.out.printf("Random credit applied: $%.2f%n", credit);
        tax -= credit;
        return tax;
    }

    // This method calculates the tax rate based on what income bracket the user falls into (California standards)
    // double, String --> double
    public static double calculateTaxRate(double taxableIncome, String status) {
        final double[] TAX_RATES = {0.01, 0.02, 0.04, 0.06, 0.08, 0.093, 0.103, 0.113, 0.123};

        final double[] SINGLE_INCOME_BRACKET = {9325, 22107, 34892, 48435, 61214, 312686, 375221, 625369};

        final double[] MARRIED_INCOME_BRACKET = {18650, 44214, 69784, 96870, 122428, 625369, 750442, 1250738};

        double[] bracket;

        DecimalFormat taxRateFormat = new DecimalFormat("0.0%");

        if (status.equalsIgnoreCase("single")) {
            bracket = SINGLE_INCOME_BRACKET;
        } else {
            bracket = MARRIED_INCOME_BRACKET;
        }

        for (int i = 0; i < bracket.length; i++) {
            if (taxableIncome <= bracket[i]) {
                System.out.println("Your tax rate is: " + taxRateFormat.format(TAX_RATES[i]));
                return TAX_RATES[i];
            }
        }

        System.out.println("Your tax rate is: " + taxRateFormat.format(TAX_RATES[TAX_RATES.length - 1]));
        return TAX_RATES[TAX_RATES.length - 1];
    }

    @Override
    public double calculateTax(TaxPayer taxPayer) {
        double taxableIncome = super.getTaxableIncome(taxPayer);

        String status = taxPayer.getStatus();

        double taxRate = calculateTaxRate(taxableIncome, status);

        double tax = taxableIncome * taxRate;

        tax = applyCredit(tax);
        tax = Math.max(0, tax);

        return tax;
    }
}

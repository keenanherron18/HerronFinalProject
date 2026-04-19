package driver;

import model.TaxCalculator;
import model.TaxPayer;

public class ProgramDriver {
    public static void main(String[] args) {


        // testing new TaxPayer class. (using TaxPayer object for future testing)
        TaxPayer test = new TaxPayer(100000, "single", "IA");
        // System.out.println(test.getIncome());
        // System.out.println(test.getState());
        // System.out.println(test.getStatus());

        TaxCalculator testCalculator = new TaxCalculator() {
            @Override
            public double calculateTax(TaxPayer taxPayer) {
                double taxableIncome = getTaxableIncome(taxPayer);
                return taxableIncome * 0.05;
            }
        };

        double result = testCalculator.calculateTax(test);
        System.out.println(testCalculator.getTaxableIncome(test));
        System.out.println(result);

        // write prompts / input validation later
    }
}
package driver;

import model.TaxCalculator;
import model.TaxManager;
import model.TaxPayer;

public class ProgramDriver {
    public static void main(String[] args) {

        // testing CaliforniaTaxCalculator and TaxManager class
        TaxManager testManager = new TaxManager();
        TaxPayer test = new TaxPayer(100000, "single", "CA");

        double tax = testManager.calculateTaxFor(test);

        System.out.printf("Tax owed: $%.2f%n", tax);


        // write prompts / input validation later
    }
}
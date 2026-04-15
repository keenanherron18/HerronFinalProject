package driver;

import model.TaxPayer;

public class ProgramDriver {
    public static void main(String[] args) {

        // testing new TaxPayer class. This is temporary code until more classes are coded
        TaxPayer test = new TaxPayer(100000, "single", "IA");

        System.out.println(test.getIncome());
        System.out.println(test.getState());
        System.out.println(test.getStatus());

        // write prompts / input validation later
    }
}
package driver;

import model.TaxManager;
import model.TaxPayer;
import java.util.Scanner;
import java.util.ArrayList;

public class ProgramDriver {
    public static void main(String[] args) {
        boolean running = true;
        boolean stateValidation = true;

        Scanner scanner = new Scanner(System.in);
        TaxManager manager = new TaxManager();

        ArrayList<TaxPayer> taxpayers = new ArrayList<>();

        while (running) {
            String state = null;

            System.out.print("Enter income: ");
            double income = scanner.nextDouble();
            scanner.nextLine();

            while (income < 0) {
                System.out.println("Income must be greater than 0");
                income = scanner.nextDouble();
            }

            System.out.print("Enter status (single/married): ");
            String status = scanner.nextLine();

            while (!status.equalsIgnoreCase("single") && !status.equalsIgnoreCase("married")) {
                System.out.println("Please enter either 'single' or 'married' for relationship status");
                status = scanner.nextLine();
            }

            while (stateValidation) {
                try {
                    System.out.print("Enter state (CA/TX/IA): ");
                    state = scanner.nextLine();

                    if (!state.equals("CA") && !state.equals("TX") && !state.equals("IA")) {
                        throw new IllegalArgumentException("Invalid state entered.");
                    }

                    stateValidation = false;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            TaxPayer payer = new TaxPayer(income, status, state);
            taxpayers.add(payer);

            System.out.print("Add another taxpayer? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();

            if (!choice.equals("y")) {
                running = false;
            }
        }

        System.out.println("\n=====Tax Results=====");

        for (TaxPayer t : taxpayers) {
            double tax = manager.calculateTaxFor(t);

            System.out.printf("Income: $%.2f%n", t.getIncome());
            System.out.println("State: " + t.getState());
            System.out.println("Status: " + t.getStatus());
            System.out.printf("Tax owed: $%.2f%n", tax);
            System.out.println("----------------------");
        }

        scanner.close();
    }
}
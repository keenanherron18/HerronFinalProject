package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {
    // Writes tax results for all taxpayers to a text file
    // ArrayList<TaxPayer>, TaxManager --> void
    public void writeToFile(ArrayList<TaxPayer> taxPayers, TaxManager manager) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("tax_results.txt")))  {
            writer.println("====Tax Result====");

            for (TaxPayer t : taxPayers) {
                double tax = manager.calculateTaxFor(t);

                writer.printf("Income: $%.2f%n", t.getIncome());
                writer.println("Status: " + t.getStatus());
                writer.println("State: " + t.getState());
                writer.printf("Tax Owed: $%.2f%n", tax);
                writer.println("----------------------");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

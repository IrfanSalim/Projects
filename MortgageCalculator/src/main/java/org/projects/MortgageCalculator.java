package org.projects;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * This is the main class for the mortgage calculator.
 */
public class MortgageCalculator {

    /**
     * The main method that prompts the user for input and calls the calculateMortgage method.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Welcome to your mortgage calculator!");
        System.out.print("Enter the loan amount: ");
        int principal = sc.nextInt();
        System.out.print("Enter the annual interest rate: ");
        float interest = sc.nextFloat();
        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

        // Calculate the mortgage amount
        double mortgage = calculateMortgage(principal, interest, years);

        // Format the mortgage amount as currency
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Display the mortgage amount
        System.out.println("Your mortgage will be: " + formattedMortgage);
    }

    /**
     * Calculates the mortgage amount based on the principal, interest rate, and number of years.
     *
     * @param principal The loan amount.
     * @param interest The annual interest rate.
     * @param years The number of years.
     * @return The mortgage amount.
     */
    public static double calculateMortgage(int principal, float interest, int years) {
        int months = years * 12;
        float monthlyInterest = (interest / 100) / 12;
        double mort =  principal * (monthlyInterest * Math.pow(1 + monthlyInterest, months)) / (Math.pow(1 + monthlyInterest, months) - 1);
        return Math.round(mort * 100.0) / 100.0;
    }
}
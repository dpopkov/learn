package learn.ijpds2nd.ch02elem;

import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, e.g., 7,25: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200.0;
        System.out.print("Enter number of years as an integer, e.g. 5: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, e.g., 120000: ");
        double loanAmount = input.nextDouble();
        double monthlyPayment = loanAmount * monthlyInterestRate
                / (1 - 1.0 / Math.pow(1.0 + monthlyInterestRate, numberOfYears * 12));
        double totalPayment = monthlyPayment * numberOfYears * 12;
        System.out.printf("The monthly payment is $%.2f%n", (int) (monthlyPayment * 100) / 100.0 );
        System.out.printf("The total payment is $%.2f%n", (int) (totalPayment * 100) / 100.0 );
        double totalPercent = totalPayment / loanAmount * 100;
        System.out.printf("The total percent is %.1f%%%n", totalPercent);
    }
}

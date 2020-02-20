package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0331CurrencyExchange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the exchange rate from dollars to RMB: ");
        double dollarsToRmbRate = in.nextDouble();
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        int direction = in.nextInt();
        if (direction == 0) {
            System.out.print("Enter the dollar amount: ");
            double dollars = in.nextDouble();
            double rmb = dollars * dollarsToRmbRate;
            System.out.printf("$%.1f is %.1f yuan%n", dollars, rmb);
        } else if (direction == 1) {
            System.out.print("Enter the RMB amount: ");
            double rmb = in.nextDouble();
            double dollars = rmb / dollarsToRmbRate;
            System.out.printf("%.1f yuan is $%.2f%n", rmb, dollars);
        } else {
            System.out.println("Incorrect input");
        }
    }
}

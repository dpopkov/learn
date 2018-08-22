package learn.core1.ch03;

import java.util.Scanner;

/**
 * This program demonstrates a <code>while</code> loop.
 */
public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.printf("You can retire in %d years.%n", years);
    }
}

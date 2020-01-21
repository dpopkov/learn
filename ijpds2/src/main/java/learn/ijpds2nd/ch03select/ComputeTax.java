package learn.ijpds2nd.ch03select;

/* Listing 3.5 */

import java.util.Scanner;

public class ComputeTax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("(0-single filer, 1-married jointly or "
                + "qualifying widow(er), 2-married separately, 3-head of "
                + "household) Enter the filing status: ");
        int status = in.nextInt();

        System.out.print("Enter the taxable income: ");
        double income = in.nextDouble();

        double tax = 0;

        if (status == 0) {
            if (income <= 8_350) {
                tax = income * 0.10;
            } else if (income <= 33_950) {
                tax = 8_350 * 0.1 + (income - 8_350) * 0.15;
            } else if (income <= 82_250) {
                tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (income - 33_950) * 0.25;
            } else if (income <= 171_550) {
                tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (income - 82_250) * 0.28;
            } else if (income <= 372_950) {
                tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (171_550 - 82_250) * 0.28
                        + (income - 171_550) * 0.33;
            } else {
                tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (171_550 - 82_250) * 0.28
                        + (372_950 - 171_550) * 0.33 + (income - 372_950) * 0.35;
            }
        } else if (status == 1) {
            System.out.println("Compute tax for married file jointly or qualifying widow(er)");
        } else if (status == 2) {
            System.out.println("Left as an exercise in Programming Exercise 3.13");
        } else if (status == 3) {
            System.out.println("Left as an exercise in Programming Exercise 3.13");
        } else {
            System.err.println("Error: invalid status");
            System.exit(1);
        }

        System.out.println("Tax is " + (int)(tax * 100) / 100.0);
    }
}

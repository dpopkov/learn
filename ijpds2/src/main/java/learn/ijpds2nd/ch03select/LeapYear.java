package learn.ijpds2nd.ch03select;

/* Listing 3.7 */

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = in.nextInt();
        boolean isLeapYear = year % 4 == 0;
        isLeapYear = isLeapYear && year % 100 != 0;
        isLeapYear = isLeapYear || year % 400 == 0;
        System.out.println(year + " is a leap year? " + isLeapYear);
    }
}

package learn.csia.ch0102;

import java.util.Scanner;

/**
 This program tests whether an integer corresponds to a leap year in the Gregorian calendar. A
 year is a leap year if it is divisible by 4 (2004), unless it is divisible by 100 in which case it is not
 (1900), unless it is divisible by 400 in which case it is (2000).
 */
public class LeapYear {
    public static void main(String[] args) {
        int year;
        if (args.length > 0) {
            year = Integer.parseInt(args[0]);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter year: ");
            year = in.nextInt();
        }
        boolean leapYear = isLeapYear(year);
        System.out.println(leapYear);
    }

    public static boolean isLeapYear(int year) {
        boolean isLeapYear;
        isLeapYear = (year % 4) == 0;
        isLeapYear = isLeapYear && (year % 100 != 0);
        isLeapYear = isLeapYear || (year % 400 == 0);
        return isLeapYear;
    }
}

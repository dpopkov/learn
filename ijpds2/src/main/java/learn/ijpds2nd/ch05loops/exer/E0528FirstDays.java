package learn.ijpds2nd.ch05loops.exer;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Scanner;

import static learn.ijpds2nd.ch05loops.exer.E0527LeapYears.isLeapYear;

public class E0528FirstDays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year and first day of the year (1-7): ");
        int year = in.nextInt();
        int day = in.nextInt();
        for (int m = 1; m <= 12; m++) {
            Month month = Month.of(m);
            System.out.printf("%s 1, %d is %s%n", month, year, DayOfWeek.of(day));
            int daysInMonth = isLeapYear(year) ? month.maxLength() : month.minLength();
            day = (day + daysInMonth - 1) % 7 + 1;
        }
    }
}

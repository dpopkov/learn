package learn.csia.ch0102.exer;

import java.util.Scanner;

/**
 1.2.23 Write a program that takes two integer command-line arguments m and
 d and prints true if day d of month m is between 3/20 and 6/20, false otherwise.
 */
public class E010223DayBetween {
    public static void main(String[] args) {
        int m, d;
        if (args.length >= 2) {
            m = Integer.parseInt(args[0]);
            d = Integer.parseInt(args[0]);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter month: ");
            m = in.nextInt();
            System.out.print("Enter day: ");
            d = in.nextInt();
        }

        boolean r = isBetween(d, m, "3/20", "6/20");
        System.out.println(r);
    }

    /**
     * Checks whether specified day and month is between specified dates.
     * @param day day of month
     * @param month month (1..12)
     * @param fromDate from date "M/DD"
     * @param toDate to date "M/DD" (inclusive)
     */
    public static boolean isBetween(int day, int month, String fromDate, String toDate) {
        String[] tokens = fromDate.split("/");
        int fromMonth = Integer.parseInt(tokens[0]);
        int fromDay = Integer.parseInt(tokens[1]);
        tokens = toDate.split("/");
        int toMonth = Integer.parseInt(tokens[0]);
        int toDay = Integer.parseInt(tokens[1]);
        if (fromMonth > toMonth) {
            throw new IllegalArgumentException("fromDate cannot be after toDate");
        }

        boolean between = true;
        if (month < fromMonth || toMonth < month ) {
            between = false;
        } else if (month == fromMonth && day < fromDay
                || month == toMonth && toDay < day) {
            between = false;
        }
        return between;
    }
}

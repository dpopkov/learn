package learn.ijpds2nd.ch06methods;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a full year (e.g., 2012): ");
        int year = in.nextInt();
        System.out.print("Enter month as number 1 and 12: ");
        int month = in.nextInt();
        String result = buildMonthCalendar(year, month);
        System.out.println(result);
    }

    private static String buildMonthCalendar(int year, int month) {
        StringBuilder sb = new StringBuilder();
        buildTitle(sb, year, month);
        buildMonth(sb, year, month);
        return sb.toString();
    }

    private static void buildMonth(StringBuilder sb, int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int weekDayIdx = date.getDayOfWeek().getValue() - 1;
        int column = 0;
        for (int i = 0; i < weekDayIdx; i++) {
            sb.append("    ");
            column++;
        }
        while (date.getMonth().getValue() == month) {
            if (column % 7 == 0) {
                sb.append(System.lineSeparator());
            }
            int day = date.getDayOfMonth();
            sb.append("  ");
            if (day < 10) {
                sb.append(' ');
            }
            sb.append(day);
            column++;
            date = date.plusDays(1);
        }
    }

    private static void buildTitle(StringBuilder sb, int year, int month) {
        sb.append("        ");
        sb.append(Month.of(month)).append(" ").append(year);
        sb.append(System.lineSeparator());
        sb.append("----------------------------");
        sb.append(System.lineSeparator());
        sb.append(" Sun Mon Tue Wed Thu Fri Sat");
        sb.append(System.lineSeparator());
    }
}

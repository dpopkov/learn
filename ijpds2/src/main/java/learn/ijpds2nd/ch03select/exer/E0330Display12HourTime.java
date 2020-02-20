package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0330Display12HourTime {
    public static void main(String[] args) {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        int currentSeconds = (int) (totalSeconds % 60);
        int totalMinutes = (int) (totalSeconds / 60);
        int currentMinutes = totalMinutes % 60;
        int totalHours = totalMinutes / 60;
        int currentHour = totalHours % 24;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter time zone offset to GMT: ");
        int offset = in.nextInt();
        currentHour = (24 + currentHour + offset) % 24;
        boolean pm = currentHour >= 12;
        System.out.printf("Current time is %02d:%02d:%02d %s local time%n",
                currentHour % 12, currentMinutes, currentSeconds, pm ? "PM" : "AM");
    }
}

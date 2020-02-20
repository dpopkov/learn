package learn.ijpds2nd.ch02elem.exerc;

import java.util.Scanner;

public class Ex0208CurrentTime {
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
        System.out.printf("Current time is %02d:%02d:%02d local time%n", currentHour, currentMinutes, currentSeconds);
    }
}

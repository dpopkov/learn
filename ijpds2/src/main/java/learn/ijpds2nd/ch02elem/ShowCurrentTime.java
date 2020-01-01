package learn.ijpds2nd.ch02elem;

public class ShowCurrentTime {
    public static void main(String[] args) {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        int currentSeconds = (int) (totalSeconds % 60);
        int totalMinutes = (int) (totalSeconds / 60);
        int currentMinutes = totalMinutes % 60;
        int totalHours = totalMinutes / 60;
        int currentHour = totalHours % 24;
        System.out.printf("Current time is %02d:%02d:%02d GMT%n", currentHour, currentMinutes, currentSeconds);
    }
}

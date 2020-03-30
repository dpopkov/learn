package learn.ijpds2nd.ch05loops.exer;

public class E0527LeapYears {
    public static void main(String[] args) {
        int count = 0;
        for (int y = 2014; y <= 2114; y++) {
            if (isLeapYear(y)) {
                System.out.printf("%5d", y);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.printf("\nThere are %d leap years in this period%n", count);
    }

    public static boolean isLeapYear(int y) {
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;
    }
}

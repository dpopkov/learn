package introtdd.ch04tdd;

public class LeapYear {
    public boolean isLeap(int year) {
        return isDivisible(year, 4) && !isDivisible(year, 100)
                || isDivisible(year, 400);
    }

    private boolean isDivisible(int year, int denominator) {
        return year % denominator == 0;
    }
}

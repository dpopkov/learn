package learn.csia.utils;

public class Doubles {

    public static final double DELTA = 1e-15;

    public static boolean close(double a, double b) {
        return Math.abs(a - b) < DELTA;
    }
}

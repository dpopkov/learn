package learn.ijpds2nd.ch05loops.exer;

public class E0512SmallestGreater {
    public static void main(String[] args) {
        final double target = 12_000.0;
        int n = (int) Math.pow(target, 1.0 / 3.0);
        double r;
        do {
            n++;
            r = cube(n);
            System.out.println("r = " + r);
        } while (r <= target);
        System.out.println("n = " + n);
    }

    private static double cube(int n) {
        return Math.pow(n, 3);
    }
}

package learn.csia.ch0102.exer;

/**
 1.2.20 Write a program that prints the sum of two random integers between 1 and
 6 (such as you might get when rolling dice)
 */
public class E010220Random {
    public static void main(String[] args) {
        final int a = 1;
        final int b = 6;
        int r1 = randomBetween(a, b);
        int r2 = randomBetween(a, b);
        int r = r1 + r2;
        System.out.println(r);
    }

    public static int randomBetween(int from, int to) {
        int r = from + (int) (Math.random() * (to - from + 1));
        return r;
    }
}

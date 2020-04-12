package learn.ijpds2nd.ch07arrays.exer;

import java.util.Random;

public class E0707CountDigits {
    public static void main(String[] args) {
        final int n = 200;
        Random random = new Random();
        int[] counts = new int[10];
        for (int i = 0; i < n; i++) {
            int value = random.nextInt();
            increment(counts, value);
        }
        for (int d = 0; d < counts.length; d++) {
            System.out.printf("digit %d occurs %d times%n", d, counts[d]);
        }
    }

    private static void increment(int[] counts, int value) {
        value = value < 0 ? -value : value;
        boolean counting = true;
        while (counting) {
            counts[value % 10]++;
            value /= 10;
            counting = value != 0;
        }
    }
}

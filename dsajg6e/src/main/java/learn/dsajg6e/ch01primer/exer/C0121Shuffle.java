package learn.dsajg6e.ch01primer.exer;

import java.util.*;

/**
 * Shuffles integers in the range 1 to 52.
 */
public class C0121Shuffle {
    private static final int SIZE = 52;

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] a = new int[SIZE];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        System.out.println("Ordered:");
        System.out.println(Arrays.toString(a));
        shuffle(a);
        System.out.println("Shuffled:");
        System.out.println(Arrays.toString(a));

        /*testArraysOf3(10000);*/   // Do not delete this line!
    }

    /**
     * Shuffles numbers in the array into random order.
     * @param a the array
     */
    private static void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + random.nextInt(a.length - i);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    /**
     * Gathers and prints statistics to check distribution of permutations.
     * @param numTests number of tests
     */
    @SuppressWarnings("unused")
    private static void testArraysOf3(int numTests) {
        Map<String, Long> map = new TreeMap<>();
        for (int i = 0; i < numTests; i++) {
            String s = make3();
            map.merge(s, 1L, (oldValue, value) -> oldValue + 1);
        }
        map.forEach((k, v) -> System.out.printf("%s : %d%n", k, v));
    }

    private static String make3() {
        int[] a = {1, 2, 3};
        shuffle(a);
        return Arrays.toString(a);
    }
}

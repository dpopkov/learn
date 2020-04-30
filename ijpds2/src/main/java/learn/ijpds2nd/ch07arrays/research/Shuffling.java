package learn.ijpds2nd.ch07arrays.research;

import java.util.Arrays;
import java.util.function.Consumer;

public class Shuffling {
    private static void shuffle(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int j = (int) (Math.random() * i);
            swap(a, i - 1, j);
        }
    }

    private static void shuffle2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int j = (int) (Math.random() * a.length);
            swap(a, i, j);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Proper shuffling");
        testShuffling(Shuffling::shuffle);
        System.out.println("Doubtful shuffling");
        testShuffling(Shuffling::shuffle2);
    }

    private static void testShuffling(Consumer<int[]> shuffler) {
        int[][] stat = new int[10][10];
        int numTests = 10000;
        for (int t = 0; t < numTests; t++) {
            int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            shuffler.accept(a);
            for (int i = 0; i < a.length; i++) {
                int v = a[i];
                stat[v][i]++;
            }
        }
        System.out.println("Distribution of values:");
        for (int[] valueDistribution : stat) {
            System.out.println(Arrays.toString(valueDistribution));
        }
    }

}

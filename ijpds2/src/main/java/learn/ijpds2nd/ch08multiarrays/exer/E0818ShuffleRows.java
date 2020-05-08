package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class E0818ShuffleRows {
    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        shuffleRows(m);
        for (int[] row : m) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void shuffleRows(int[][] a) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int[] tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}

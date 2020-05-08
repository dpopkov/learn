package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;

public class E0816SortTwoDimensional {
    public static void sort(int[][] m) {
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = 0; j < m.length - 1 - i; j++) {
                if (Arrays.compare(m[j], m[j + 1]) < 0) {
                    swap(m, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

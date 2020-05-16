package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;

public class E0829Identical {
    /** Returns true if the two arrays have the same contents. */
    static boolean equals(int[][] m1, int[][] m2) {
        int capacity = m1.length * m1[0].length;
        int[] v1 = new int[capacity];
        int[] v2 = new int[capacity];
        copyTo(v1, m1);
        copyTo(v2, m2);
        Arrays.sort(v1);
        Arrays.sort(v2);
        return Arrays.equals(v1, v2);
    }

    private static void copyTo(int[] destination, int[][] source) {
        int k = 0;
        for (int[] row : source) {
            for (int v : row) {
                destination[k++] = v;
            }
        }
    }
}

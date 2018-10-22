package learn.csia.ch0104.exer;

import java.util.Arrays;
import java.util.Random;

public class E010413Copy2dArray {
    private static Random random = new Random();

    public static void main(String[] args) {
        int[][] a = create(3, 2, 6);
        System.out.println(Arrays.deepToString(a));
        int[][] b = copy(a);
        System.out.println(Arrays.deepToString(b));
    }

    private static int[][] copy(int[][] a) {
        int[][] b = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
            b[i] = new int[a[i].length];
            if (b[i].length >= 0) System.arraycopy(a[i], 0, b[i], 0, b[i].length);
        }
        return b;
    }

    private static int[][] create(int n, int m1, int m2) {
        int bound = n * m2;
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[m1 + random.nextInt(m2 - m1)];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(bound);
            }
        }
        return a;
    }
}

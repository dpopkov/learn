package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Random;

public class E0822Even1s {
    static boolean hasEvenNumber(int[][] m) {
        for (int[] row : m) {
            int count = 0;
            for (int v : row) {
                count += v;
            }
            if (count % 2 == 1) {
                return false;
            }
        }
        for (int c = 0; c < m[0].length; c++) {
            int count = 0;
            for (int[] row : m) {
                count += row[c];
            }
            if (count % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unused")
    static int[][] generate(final int size) {
        Random random = new Random();
        int[][] m = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                m[r][c] = random.nextInt(2);
            }
        }
        return m;
    }
}

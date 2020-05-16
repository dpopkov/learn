package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;

public class E0827ColumnSorting {
    static double[][] sortColumns(double[][] m) {
        int size = m.length;
        double[][] r = new double[size][];
        for (int i = 0; i < size; i++) {
            r[i] = Arrays.copyOf(m[i], size);
        }
        for (int col = 0; col < size; col++) {
            sortColumn(r, col);
        }
        return r;
    }

    private static void sortColumn(double[][] m, int col) {
        int size = m.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                int next = j + 1;
                if (m[j][col] > m[next][col]) {
                    swap(m, col, j, next);
                }
            }
        }
    }

    private static void swap(double[][] m, int col, int i, int j) {
        double temp = m[i][col];
        m[i][col] = m[j][col];
        m[j][col] = temp;
    }
}

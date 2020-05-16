package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;

public class E0826RowSorting {
    /** Returns a new array where all rows are sorted. */
    static double[][] sortRows(double[][] m) {
        double[][] r = new double[m.length][];
        for (int i = 0; i < m.length; i++) {
            r[i] = Arrays.copyOf(m[i], m[i].length);
        }
        for (double[] row : r) {
            Arrays.sort(row);
        }
        return r;
    }
}

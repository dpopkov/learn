package learn.dsajg6e.ch03fund.exer;

import java.util.function.IntBinaryOperator;

/**
 * Matrix class that can add and multiply two-dimensional
 * arrays of integers.
 */
public class P0336Matrix {

    public int[][] add(int[][] a, int[][] b) {
        return apply(a, b, Integer::sum);
    }

    public int[][] multiply(int[][] a, int[][] b) {
        return apply(a, b, (x, y) -> x * y);
    }

    public int[][] apply(int[][] a, int[][] b, IntBinaryOperator op) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Arrays must have equal sizes");
        }
        int[][] rst = new int[a.length][];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = new int[a[i].length];
            for (int j = 0; j < a[i].length; j++) {
                rst[i][j] = op.applyAsInt(a[i][j], b[i][j]);
            }
        }
        return rst;
    }
}

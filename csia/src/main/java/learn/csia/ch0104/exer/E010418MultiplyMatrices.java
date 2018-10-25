package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;

public class E010418MultiplyMatrices {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        int[][] c = multiply(a, b);
        ArrayUtils.printTwoDimensional(c);
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException(
                    "Number of columns in the first matrix must be equal " +
                    "to the number of rows in the second matrix");
        }
        int[][] rst = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    rst[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return rst;
    }
}

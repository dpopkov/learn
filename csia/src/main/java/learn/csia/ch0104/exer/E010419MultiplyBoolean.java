package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;

public class E010419MultiplyBoolean {
    public static void main(String[] args) {
        boolean[][] a = {
                {true, false},
                {false, true},
                {true, true}
        };
        boolean[][] b = {
                {false, true},
                {true, false}
        };
        boolean[][] c = multiply(a, b);
        ArrayUtils.printTwoDimensional(c, 'T', 'f');
    }

    private static boolean[][] multiply(boolean[][] a, boolean[][] b) {
        boolean[][] c = new boolean[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] = c[i][j] || a[i][k] && b[k][j];
                }
            }
        }
        return c;
    }
}

/*
1.4.15
Transpose a square array in place.
 */
package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;

public class E010415TransposeSquare {
    public static void main(String[] args) {
        int[][] a = {
                {11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22},
                {23, 24, 25, 26}
        };
        System.out.println("Initial:");
        ArrayUtils.printTwoDimensional(a);
        transpose(a);
        System.out.println("Transposed:");
        ArrayUtils.printTwoDimensional(a);
    }

    private static void transpose(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }
}

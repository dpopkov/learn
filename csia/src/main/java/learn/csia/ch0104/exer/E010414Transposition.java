/*
1.4.14
Prints the transposition of a two-dimensional array.
 */
package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;

import java.io.FileNotFoundException;

public class E010414Transposition {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "io/data/array.txt";
        int[][] a = ArrayUtils.readTwoDimensional(path);
        System.out.println("Initial array:");
        ArrayUtils.printTwoDimensional(a);
        printTransposition(a);
    }

    private static void printTransposition(int[][] a) {
        for (int i = 0; i < a[i].length; i++) {
            for (int[] b : a) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
    }
}

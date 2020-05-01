package learn.ijpds2nd.ch08multiarrays;

import java.util.Scanner;

/** Listing 8.1 */
public class PassTwoDimensionalArray {
    public static void main(String[] args) {
        int[][] m = getArray();
        System.out.println("\nSum of all elements is " + sum(m));
    }

    private static int sum(int[][] m) {
        int total = 0;
        for (int[] row : m) {
            for (int v : row) {
                total += v;
            }
        }
        return total;
    }

    private static int[][] getArray() {
        Scanner in = new Scanner(System.in);
        int[][] m = new int[3][4];
        System.out.println("Enter " + m.length + " rows and "
                + m[0].length + " columns: ");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = in.nextInt();
            }
        }
        return m;
    }
}

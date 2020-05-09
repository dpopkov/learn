package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;
import learn.ijpds2nd.tools.ConsoleInput;

import java.util.function.IntUnaryOperator;

public class E0819PatternRecognition {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[][] a = in.inputRectangularIntArray();
        boolean r = containsConsecutive(a, 4);
        System.out.printf("The array%n%s%n%s 4 consecutive elements%n",
                ArrayUtils.toString(a), r ? "contains" : "does not contain");
    }

    static boolean containsConsecutive(int[][] a, int num) {
        return foundInRows(a, num)
                || foundInCols(a, num)
                || foundInLeftDiagonals(a, num)
                || foundInRightDiagonals(a, num);
    }

    private static boolean foundInRightDiagonals(int[][] a, int num) {
        int r = 0;
        int c = a[0].length - 1;
        IntUnaryOperator increment = x -> x + 1;
        IntUnaryOperator decrement = x -> x - 1;
        while (c >= 0) {
            if (foundInOneDiagonal(a, num, r, c, increment, decrement)) {
                return true;
            }
            c--;
        }
        r = 1;
        c = a[0].length - 1;
        while (r <= a.length - num) {
            if (foundInOneDiagonal(a, num, r, c, increment, decrement)) {
                return true;
            }
            r++;
        }
        return false;
    }

    private static boolean foundInLeftDiagonals(int[][] a, int num) {
        final int lastRow = a.length - num;
        final int lastCol = a[0].length - num;
        int r = 0;
        int c = 0;
        IntUnaryOperator increment = x -> x + 1;
        while (c <= lastCol && r <= lastRow) {
            if (foundInOneDiagonal(a, num, r, c, increment, increment)) {
                return true;
            }
            c++;
        }
        r = 1;
        c = 0;
        while (c <= lastCol && r <= lastRow) {
            if (foundInOneDiagonal(a, num, r, c, increment, increment)) {
                return true;
            }
            r++;
        }
        return false;
    }

    private static boolean foundInOneDiagonal(int[][] a, int num, int startRow, int startCol,
                                              IntUnaryOperator advanceRow, IntUnaryOperator advanceCol) {
        int prev = a[startRow][startCol];
        int count = 1;
        for (int i = advanceRow.applyAsInt(startRow), j = advanceCol.applyAsInt(startCol);
             i < a.length && i >= 0 && j < a[i].length && j >= 0;
             i = advanceRow.applyAsInt(i), j = advanceCol.applyAsInt(j)) {
            if (a[i][j] == prev) {
                count++;
                if (count == num) {
                    return true;
                }
            } else {
                prev = a[i][j];
                count = 1;
            }
        }
        return false;
    }

    private static boolean foundInCols(int[][] a, int num) {
        for (int c = 0; c < a[0].length; c++) {
            int prev = a[0][c];
            int count = 1;
            for (int r = 1; r < a.length; r++) {
                if (a[r][c] == prev) {
                    count++;
                    if (count == num) {
                        return true;
                    }
                } else {
                    prev = a[r][c];
                    count = 1;
                }
            }
        }
        return false;
    }

    private static boolean foundInRows(int[][] a, int num) {
        for (int[] row : a) {
            int prev = row[0];
            int count = 1;
            for (int i = 1; i < row.length; i++) {
                if (row[i] == prev) {
                    count++;
                    if (count == num) {
                        return true;
                    }
                } else {
                    prev = row[i];
                    count = 1;
                }
            }
        }
        return false;
    }


}

package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;

/*
A Latin square is na n-by-n array filled with n different Latin letters,
each occurring exactly once in each row and once in each column
 */
public class E0836LatinSquare {
    public boolean isLatinSquare(char[][] letters) {
        for (char[] row : letters) {
            if (!isValidRow(row)) {
                return false;
            }
        }
        for (int c = 0; c < letters.length; c++) {
            if (!isValidColumn(letters, c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[] row) {
        boolean[] flags = new boolean[row.length];
        for (char ch : row) {
            int idx = ch - 'A';
            if (idx < row.length) {
                flags[idx] = true;
            } else {
                return false;
            }
        }
        return ArrayUtils.allTrue(flags);
    }

    private boolean isValidColumn(char[][] a, int col) {
        int size = a.length;
        boolean[] flags = new boolean[size];
        for (char[] row : a) {
            int idx = row[col] - 'A';
            if (idx < size) {
                flags[idx] = true;
            } else {
                return false;
            }
        }
        return ArrayUtils.allTrue(flags);
    }
}

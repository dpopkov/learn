package learn.ijpds2nd.ch08multiarrays.exer;

public class E0835LargestBlock {
    /**
     * Finds the maximum square sub-matrix whose elements are all 1s.
     * @param m source square matrix
     * @return array that contains row and column indices for the first element
     *          in the sub-matrix, and the third value is the number of the rows
     *          in the square sub-matrix.
     */
    static int[] findLargestBlock(int[][] m) {
        int size = m.length;
        int[] result = new int[3];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (m[r][c] == 1) {
                    int subSize = countSizeOfSubMatrix(m, r, c);
                    if (subSize > result[2]) {
                        result[0] = r;
                        result[1] = c;
                        result[2] = subSize;
                    }
                }
            }
        }
        return result;
    }

    private static int countSizeOfSubMatrix(int[][] m, int row, int col) {
        int colCount = 1;
        int minRowCount = 1;
        int size = m.length;
        for (int r = row + 1; r < size; r++) {
            if (m[r][col] == 1) {
                minRowCount++;
            } else {
                break;
            }
        }
        for (int c = col + 1; c < size; c++) {
            int rowCount = 0;
            for (int r = row; r < size; r++) {
                if (m[r][c] == 1) {
                    rowCount++;
                } else {
                    break;
                }
            }
            if (rowCount > 0) {
                colCount++;
            } else {
                break;
            }
            if (rowCount < minRowCount) {
                minRowCount = rowCount;
            }
        }
        return Math.min(minRowCount, colCount);
    }
}

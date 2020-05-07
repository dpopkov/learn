package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;

public class E0810LargestRowAndColumn {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = (int) (Math.random() * 2);
            }
        }
        System.out.println(ArrayUtils.toString(matrix));
        int largestRowSum = 0;
        int largestRowIdx = 0;
        int largestColSum = 0;
        int largestColIdx = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int v : matrix[i]) {
                rowSum += v;
            }
            for (int[] row : matrix) {
                colSum += row[i];
            }
            if (rowSum > largestRowSum) {
                largestRowSum = rowSum;
                largestRowIdx = i;
            }
            if (colSum > largestColSum) {
                largestColSum = colSum;
                largestColIdx = i;
            }
        }
        System.out.println("The largest row index: " + largestRowIdx);
        System.out.println("The largest col index: " + largestColIdx);
    }
}

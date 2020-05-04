package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

public class E0801SumRow {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        double[][] matrix = in.input2DMatrix(3, 4);
        for (int r = 0; r < matrix.length; r++) {
            double sum = sumRow(matrix[r]);
            System.out.printf("Sum of the elements at row %d is %.1f%n", r, sum);
        }
    }

    private static double sumRow(double[] row) {
        double sum = 0;
        for (double d : row) {
            sum += d;
        }
        return sum;
    }
}

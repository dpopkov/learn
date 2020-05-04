package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

public class E0802AverageDiagonal {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        double[][] matrix = in.input2DMatrix(4, 4);
        double avg = averageMajorDiagonal(matrix);
        System.out.printf("Average of the elements in the major diagonal is %.3f%n", avg);
    }

    private static double averageMajorDiagonal(double[][] matrix) {
        double sum = 0;
        for (int i = 0, j = 0; i < matrix.length; i++, j++) {
            sum += matrix[i][j];
        }
        return sum / matrix.length;
    }
}

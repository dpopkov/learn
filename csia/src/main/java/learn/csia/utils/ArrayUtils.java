package learn.csia.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayUtils {
    public static double sum(double[] a) {
        double total = 0.0;
        for (double d : a) {
            total += d;
        }
        return total;
    }

    public static double[] averageOfRows(int[][] a, double[] weights) {
        if (a[0].length != weights.length) {
            throw new IllegalArgumentException("Number of columns must be equal to number of weights");
        }
        if (!Doubles.close(sum(weights), 1.0)) {
            throw new IllegalArgumentException("Weights must sum up to 1.0");
        }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < weights.length; j++) {
                sum += a[i][j] * weights[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public static void printTwoDimensional(int[][] a) {
        for (int[] b : a) {
            for (int c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void printTwoDimensional(double[][] a, int digitsAfterPoint) {
        String frmt = doubleFormatString(digitsAfterPoint);
        for (double[] b : a) {
            for (double c : b) {
                System.out.printf(frmt, c);
            }
            System.out.println();
        }
    }

    public static void printVertical(double[] a, int digitsAfterPoint) {
        String frmt = doubleFormatString(digitsAfterPoint);
        for (double c : a) {
            System.out.println(String.format(frmt, c));
        }
    }

    private static String doubleFormatString(int digitsAfterPoint) {
        return String.format("%%.%df ", digitsAfterPoint);
    }

    public static void printTwoDimensional(boolean[][] a, char ifTrue, char ifFalse) {
        for (boolean[] b : a) {
            for (boolean c : b) {
                System.out.print((c ? ifTrue : ifFalse) + " ");
            }
            System.out.println();
        }
    }

    public static void printTwoDimensionalIndexed(boolean[][] a, char ifTrue, char ifFalse) {
        System.out.print("   ");
        for (int j = 0; j < a[0].length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < a[i].length; j++) {
                System.out.print((a[i][j] ? ifTrue : ifFalse) + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readTwoDimensional(String path) throws FileNotFoundException {
        List<int[]> arrays = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            String line = scanner.nextLine();
            int[] numbers = parseLine(line);
            arrays.add(numbers);
            while (scanner.hasNextLine()) {
                numbers = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = scanner.nextInt();
                }
                arrays.add(numbers);
                scanner.nextLine();
            }
        }
        return arrays.toArray(new int[0][]);
    }

    public static int[] parseLine(String line) {
        String[] tokens = line.split(" ");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
}

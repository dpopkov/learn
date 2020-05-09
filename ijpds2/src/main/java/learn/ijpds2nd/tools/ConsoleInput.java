package learn.ijpds2nd.tools;

import java.util.Locale;
import java.util.Scanner;

/**
 * Contains methods for input using standard system console and {@link Scanner}.
 */
public class ConsoleInput {
    private final Scanner scanner;
    {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }

    public int[] inputSizeAndArray() {
        int n = getInt("Enter number of values: ");
        return getIntArray(n);
    }

    public int getInt(String prompt) {
        printWithColon(prompt);
        return scanner.nextInt();
    }

    public int[] getIntArray(int size) {
        int[] a = new int[size];
        System.out.printf("Enter %d integer values: ", size);
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public String next() {
        return scanner.next();
    }

    public String nextLine(String prompt) {
        printWithColon(prompt);
        return scanner.nextLine();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public int[] inputIntArray(String prompt) {
        printWithColon(prompt);
        String[] tokens = scanner.nextLine().split(" ");
        int[] a = new int[tokens.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        return a;
    }

    public int[][] inputRectangularIntArray() {
        printWithColon("Enter number of rows and columns: ");
        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        int[][] a = new int[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                a[r][c] = scanner.nextInt();
            }
        }
        return a;
    }

    public double[][] input2DMatrix(int height, int width) {
        String prompt = String.format("Enter a %d-by-%d matrix row by row: ", height, width);
        printWithColon(prompt);
        double[][] m = new double[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                m[r][c] = scanner.nextDouble();
            }
        }
        return m;
    }

    private void printWithColon(String prompt) {
        prompt = ensureColon(prompt);
        System.out.print(prompt);
    }

    private String ensureColon(String prompt) {
        if (!prompt.endsWith(": ")) {
            if (prompt.endsWith(":")) {
                prompt = prompt + " ";
            } else {
                prompt = prompt + ": ";
            }
        }
        return prompt;
    }
}

package learn.ijpds2nd.tools;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {
    private static Random random;

    @SuppressWarnings("unused")
    public static void shuffle(int[] array) {
        if (random == null) {
            random = ThreadLocalRandom.current();
        }
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static void shuffle(Object[] array) {
        if (random == null) {
            random = ThreadLocalRandom.current();
        }
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            if (i != j) {
                Object tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static int[] parseToIntArray(String numbers) {
        String[] tokens = numbers.trim().split("\\s+");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    public static char[][] parseToCharCharArray(String letters) {
        String[] tokens = letters.trim().split("\\s+");
        int size = tokens.length;
        char[][] result = new char[size][size];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = tokens[i].charAt(j);
            }
        }
        return result;
    }

    public static boolean allTrue(boolean[] a) {
        for (boolean b : a) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(double[][] a, double[][] b, double delta) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                if (Math.abs(a[r][c] - b[r][c]) > delta) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String toString(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : a) {
            for (int value : row) {
                sb.append(value).append(' ');
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

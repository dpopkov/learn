package learn.ijpds2nd.tools;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {
    private static Random random;

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

    public static int[] shuffleCopy(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        shuffle(result);
        return result;
    }

    public static Object[] shuffleCopy(Object[] array) {
        Object[] result = Arrays.copyOf(array, array.length);
        shuffle(result);
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            shuffle(a);
            System.out.println(Arrays.toString(a));
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
}
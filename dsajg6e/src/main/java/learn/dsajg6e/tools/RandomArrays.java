package learn.dsajg6e.tools;

import java.util.Random;

/**
 * Contains utility methods for creating arrays of random values.
 */
public class RandomArrays {
    private static final Random random = new Random();

    /**
     * Creates an array of int values where each value is between 0 ane the specified bound (exclusive).
     * @param size size of the array
     * @param bound upper bound (exclusive) of arrays elements
     * @return array of random int values
     */
    public static int[] makeInt(int size, int bound) {
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(bound);
        }
        return a;
    }

    /**
     * Creates an array of random float values.
     * @param size size of the array
     * @return array of random numbers
     */
    public static float[] makeFloat(int size) {
        float[] a = new float[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextFloat();
        }
        return a;
    }
}

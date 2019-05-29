package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.RandomArrays;

import java.util.Arrays;

public class C0120Different {
    public static void main(String[] args) {
        float[] fa = RandomArrays.makeFloat(10);
        System.out.println(Arrays.toString(fa));
        boolean rst = allDifferent(fa, 0.000001F);
        System.out.println(rst ? "all numbers are different" : "not all numbers are different");
    }

    /**
     * Determines if all the numbers in the array are different from each other.
     * @param a array of numbers
     * @param delta maximum allowed difference between numbers
     * @return true if all the numbers are different, false otherwise
     */
    public static boolean allDifferent(float[] a, float delta) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) <= delta) {
                    return false;
                }
            }
        }
        return true;
    }
}

package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0721NormalizingIntegers {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.getIntArray(10);
        double[] n = normalize(a);
        System.out.println("Normalized array:");
        System.out.println(Arrays.toString(n));
    }

    private static double[] normalize(int[] a) {
        double max = findMax(a);
        double[] n = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            n[i] = a[i] / max;
        }
        return n;
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }
}

/* 1.4.1    Sampling without replacement. */
package learn.csia.ch0104;

import learn.csia.utils.CliAppArgs;

public class Sampling {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Sample size", "Range");
        int sampleSize = cli.nextInt();
        int range = cli.nextInt();
        if (sampleSize > range) {
            throw new IllegalArgumentException("Sample size can not be greater than range");
        }
        int[] perm = new int[range];

        initialize(perm);
        makeSampleInPlace(perm, sampleSize);
        printFirst(perm, sampleSize);
    }

    private static void makeSampleInPlace(int[] values, int sampleSize) {
        for (int i = 0; i < sampleSize; i++) {
            int r = i + (int) (Math.random() * (values.length - i));
            int t = values[r];
            values[r] = values[i];
            values[i] = t;
        }
    }

    private static void initialize(int[] perm) {
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
    }

    private static void printFirst(int[] values, int sampleSize) {
        for (int i = 0; i < sampleSize; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
}

package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

/**
 * 1.3.12 Write a program FunctionGrowth that prints a table of the values log n, n,
 * n log<sub>e</sub> n, n^2, n^3, and 2^n for n = 16, 32, 64, ... , 2,048. Use tabs (\t characters) to align
 * columns.
 */
public class E010312 {
    private static class FunctionGrowth {
        void print(int n) {
            for (int i = 1; i <= n; i++) {
                System.out.printf("\t%12.2f\t%12.2f\t%12.2f\t%12.2f\t%12.2f\t%12.2f%n",
                        Math.log(i),
                        (double)i,
                        i * Math.log(i),
                        Math.pow(i, 2),
                        Math.pow(i, 3),
                        Math.pow(2, i));
            }
        }
    }

    public static void main(String[] args) {
        int n = new CliAppArgs(args, "Enter n").nextInt();
        new FunctionGrowth().print(n);
    }
}

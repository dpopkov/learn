/*
1.4.12
Takes a variable number of integer command-line arguments
and prints the integer i with probability proportional
to the i-th command-line argument.

This exercise IS NOT FINISHED!

 */
package learn.csia.ch0104.exer;

public class E010412DiscreteDistribution {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed");
            return;
        }
        int[] values = new int[args.length];
        int[] counts = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            values[i] = Integer.parseInt(args[i]);
        }
        for (int current : values) {
            for (int j = 0; j < counts.length; j++) {
                if (values[j] == current) {
                    counts[j]++;
                }
            }
        }
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%d : %d : %.2f%n", i, values[i], ((double)counts[i]) / counts.length);
        }
    }
}

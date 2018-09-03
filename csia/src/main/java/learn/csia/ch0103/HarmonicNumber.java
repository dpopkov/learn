package learn.csia.ch0103;

import learn.csia.utils.CliAppArgs;

public class HarmonicNumber {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter number of terms in sum");
        int n = in.nextInt();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println(sum);
    }
}

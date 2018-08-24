package learn.csia.ch0103;

import learn.csia.utils.NumberArgs;

public class HarmonicNumber {
    public static void main(String[] args) {
        NumberArgs in = new NumberArgs(args, new String[] {"Enter number of terms in sum"});
        int n = in.nextInt();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        System.out.println(sum);
    }
}

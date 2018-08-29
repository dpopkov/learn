package learn.csia.ch0103;

import learn.csia.utils.NumberArgs;

public class Factors {
    public static void main(String[] args) {
        NumberArgs in = new NumberArgs(args, new String[] {"Number for factorization"});
        long n = in.nextLong();
        for (long factor = 2; factor <= n / factor; factor++) {
            while (n % factor == 0) {
                n /= factor;
                System.out.print(factor + " ");
            }
        }
        if (n > 1) {
            System.out.print(n);
        }
        System.out.println();
    }
}

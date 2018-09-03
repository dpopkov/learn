package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.27 Modify Factors to print just one copy each of the prime divisors.
 */
public class E010327Factors {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Number for factorization");
        long n = in.nextLong();
        List<Long> factors = new E010327Factors().getFactors(n);
        System.out.println(factors);
    }

    public List<Long> getFactors(long number) {
        List<Long> factors = new ArrayList<>();
        for (long factor = 2; factor <= number / factor; factor++) {
            if (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
            while (number % factor == 0) {
                number /= factor;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}

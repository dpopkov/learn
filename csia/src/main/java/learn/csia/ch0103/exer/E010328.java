package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;
import learn.csia.utils.Stopwatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.28 Run quick experiments to determine the impact of using the termination
 * condition (factor <= n/factor) instead of (factor < n) in Factors in program
 * 1.3.9. For each method, fnd the largest n such that when you type in an n-digit
 * number, the program is sure to fnish within 10 seconds.
 */
public class E010328 {
    public static void main(String[] args) {
        // Example number for factorization: 3757208
        //[2, 7, 13, 397]
        CliAppArgs in = new CliAppArgs(args, "Number for factorization");
        long n = in.nextLong();

        E010328 factorizator = new E010328();
        Stopwatch sw = new Stopwatch();

        sw.start();
        List<Long> factors = factorizator.getFactors(n);
        long ms = sw.stop();
        System.out.println(factors);
        System.out.printf("%d ms elapsed%n", ms);

        sw.start();
        factors = factorizator.getFactorsLonger(n);
        ms = sw.stop();
        System.out.println(factors);
        System.out.printf("%d ms elapsed%n", ms);
    }

    private List<Long> getFactors(long number) {
        List<Long> factors = new ArrayList<>();
        for (long factor = 2; factor <= number / factor; factor++) {
            while (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }

    private List<Long> getFactorsLonger(long number) {
        List<Long> factors = new ArrayList<>();
        for (long factor = 2; factor < number; factor++) {
            while (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}

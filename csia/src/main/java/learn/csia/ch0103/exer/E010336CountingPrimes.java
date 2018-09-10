package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.36 Counting primes. Write a program PrimeCounter that takes an integer
 * command-line argument n and finds the number of primes less than or equal to n.
 * Use it to print out the number of primes less than or equal to 10 million. Note : If
 * you are not careful, your program may not fnish in a reasonable amount of time!
 */
public class E010336CountingPrimes {
    public int countPrimesUpTo(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter n");
        int n = in.nextInt();
        int count = new E010336CountingPrimes().countPrimesUpTo(n);
        System.out.println(count + " primes");
    }
}

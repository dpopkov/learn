/*
1.4.3
Sieve of Eratosthenes.
 */
package learn.csia.ch0104;

import learn.csia.utils.CliAppArgs;

public class PrimeSieve {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter n");
        int n = cli.nextInt();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        System.out.println(primes);
    }
}

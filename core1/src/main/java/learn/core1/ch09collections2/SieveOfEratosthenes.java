package learn.core1.ch09collections2;

import java.util.BitSet;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 2_000_000;
        long start = System.currentTimeMillis();
        BitSet bits = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            bits.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (bits.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    bits.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (bits.get(i)) {
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}

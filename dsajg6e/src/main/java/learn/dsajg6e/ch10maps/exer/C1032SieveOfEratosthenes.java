package learn.dsajg6e.ch10maps.exer;

import java.util.ArrayList;
import java.util.List;

public class C1032SieveOfEratosthenes {
    private static final boolean PRIME = false;
    private static final boolean NOT_PRIME = true;

    /**
     * Finds prime numbers beginning from the specified number
     * and to the specified boundary number exclusive.
     * @return array of prime numbers
     */
    public int[] primes(int from, int to) {
        boolean[] all = new boolean[to];
        int stop = (int) Math.sqrt(to);
        int m = findNotTrue(all, 2);
        while (m <= stop && m != -1) {
            int j = m + m;
            while (j < all.length) {
                all[j] = NOT_PRIME;
                j += m;
            }
            m = findNotTrue(all, m + 1);
        }
        List<Integer> buffer = new ArrayList<>();
        for (int k = from; k < all.length; k++) {
            if (all[k] == PRIME) {
                buffer.add(k);
            }
        }
        int[] result = new int[buffer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = buffer.get(i);
        }
        return result;
    }

    /**
     * Finds prime numbers to the specified boundary number exclusive.
     * @return array of prime numbers
     */
    public int[] primes(int to) {
        return primes(2, to);
    }

    private int findNotTrue(boolean[] b, int from) {
        for (int i = from; i < b.length; i++) {
            if (!b[i]) {
                return i;
            }
        }
        return -1;
    }
}

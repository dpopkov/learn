package learn.dsajg6e.ch09pq2.exer;

import java.util.Comparator;

/**
 * Comparator for non-negative integers that determines order based
 * on the number of 1's in each integer's binary representation.
 */
public class C0941OnesComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(countBits(a), countBits(b));
    }

    private int countBits(Integer a) {
        int numBits = 0;
        int value = a;
        for (int i = 0; i < Integer.SIZE; i++) {
            numBits += value & 1;
            value >>>= 1;
        }
        return numBits;
    }
}

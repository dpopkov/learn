package learn.dsajg6e.ch10maps.exer;

/*
 * C-10.60
 * Set whose elements are integers in the range [0, N - 1].
 * Represents a set A of this type by means of a boolean
 * array B, where we say that x is in A if and only if B[x] = true.
 */
public class C1060BitVector {
    private final boolean[] bits;

    public C1060BitVector(int capacity) {
        bits = new boolean[capacity];
    }

    public void add(int x) {
        if (x < 0 || x >= bits.length) {
            throw new IllegalArgumentException("This integer cannot be added to the vector: " + x);
        }
        bits[x] = true;
    }

    public boolean contains(int x) {
        if (x < 0 || x >= bits.length) {
            throw new IllegalArgumentException("This integer cannot be used to access the vector: " + x);
        }
        return bits[x];
    }
}

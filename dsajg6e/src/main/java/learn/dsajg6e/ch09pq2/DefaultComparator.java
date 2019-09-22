package learn.dsajg6e.ch09pq2;

import java.util.Comparator;

/**
 * Implements {@link Comparator} based upon the natural ordering of its element type.
 */
public class DefaultComparator<E> implements Comparator<E> {
    @SuppressWarnings("unchecked")
    @Override
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}

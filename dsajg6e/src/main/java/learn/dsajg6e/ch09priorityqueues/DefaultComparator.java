package learn.dsajg6e.ch09priorityqueues;

import java.util.Comparator;

/**
 * CF-9.4
 * Comparator based upon the natural ordering of its element type.
 */
public class DefaultComparator<E> implements Comparator<E> {
    @SuppressWarnings("unchecked")
    @Override
    public int compare(E o1, E o2) throws ClassCastException {
        return ((Comparable<E>) o1).compareTo(o2);
    }
}

package learn.dsajg6e.ch10maps.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * C-10.59
 * Give a concrete implementation of the retainAll method for the set ADT, using
 * only the other fundamental methods of the set.
 * You are to assume that the underlying set implementation uses fail-fast iterators
 */
public class C1059SimpleSet<E> {
    private final List<E> list = new ArrayList<>();

    public void add(E e) {
        if (!containsElement(e)) {
            list.add(e);
        }
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public int size() {
        return list.size();
    }

    /** Retains only the elements in this set that are contained in the specified collection. */
    public void retainAll(C1059SimpleSet<E> others) {
        for (int i = 0; i < list.size();) {
            if (others.contains(list.get(i))) {
                i++;
            } else {
                // Using here method remove(int) because it would be called from the set's method remove(E) anyway
                list.remove(i);
            }
        }
    }

    private boolean containsElement(E e) {
        return list.contains(e);
    }
}

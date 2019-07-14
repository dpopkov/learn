package learn.dsajg6e.ch07list.positional;

import java.util.Iterator;

/**
 * CF 7.16-7.17
 * Maintains a list of elements ordered according to access frequency.
 */
public class FavoritesList<E> {
    protected final LinkedPositionalList<Item<E>> list = new LinkedPositionalList<>();

    public FavoritesList() {
    }

    /* Public methods. */

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    /** Accesses element e (possibly new), increasing its access count. */
    public void access(E e) {
        Position<Item<E>> p = findPosition(e);
        if (p == null) {
            p = list.addLast(new Item<>(e));
        }
        p.getElement().increment();
        moveUp(p);
    }

    /** Removes element equal to e from the list of favorites (if found). */
    public void remove(E e) {
        Position<Item<E>> position = findPosition(e);
        if (position != null) {
            list.remove(position);
        }
    }

    /** Returns an iterable collection of the k most frequently accessed elements. */
    public Iterable<E> getFavorites(int k) {
        if (k < 0 || k > size()) {
            throw new IllegalArgumentException("Invalid k: " + k);
        }
        LinkedPositionalList<E> result = new LinkedPositionalList<>();
        Iterator<Item<E>> iter = list.iterator();
        for (int i = 0; i < k; i++) {
            result.addLast(iter.next().getValue());
        }
        return result;
    }

    /* Non-public utilities. */

    /** Provides shorthand notation to retrieve user's element stored at Position p. */
    protected E value(Position<Item<E>> p) {
        return p.getElement().getValue();
    }

    /** Provides shorthand notation to retrieve count of item stored at Position p. */
    protected int count(Position<Item<E>> p) {
        return p.getElement().getCount();
    }

    /** Returns Position having element equal to e (or null if not found). */
    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();
        while (walk != null && !e.equals(value(walk))) {
            walk = list.after(walk);
        }
        return walk;
    }

    /** Moves item at Position p to a Position earlier in the list based on access count. */
    protected void moveUp(Position<Item<E>> p) {
        int cnt = count(p);
        Position<Item<E>> walk = p;
        while (walk != list.first() && count(list.before(walk)) < cnt) {
            walk = list.before(walk);
        }
        if (walk != p) {
            list.addBefore(walk, list.remove(p));
        }
    }

    /* Nested Item class. */

    /**
     * {@code Item} stores the element value and its access count as a single instance.
     * @param <E> type of the element
     */
    protected static class Item<E> {
        private final E value;
        private int count = 0;

        public Item(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }
}

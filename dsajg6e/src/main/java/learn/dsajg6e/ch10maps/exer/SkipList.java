package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;

public interface SkipList<K extends Comparable<K>> {
    Position<K> put(K key);
    /** Returns the position following p on the same level. */
    Position<K> next(Position<K> p);
    /** Returns the position preceding p on the same level. */
    Position<K> prev(Position<K> p);
    /** Returns the position above p in the same tower. */
    Position<K> above(Position<K> p);
    /** Returns the position below p in the same tower. */
    Position<K> below(Position<K> p);
    /** Returns position with the largest key that is less or equal to the specified key. */
    Position<K> skipSearch(K key);
    /** Removes the specified key and returns its position, or null if no key found. */
    Position<K> remove(K key);
    /** Returns the number of elements in the list. */
    int size();
}

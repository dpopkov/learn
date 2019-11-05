package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;

public interface SkipList<K extends Comparable<K>> {
    Position<K> put(K key);
    Position<K> next(Position<K> p);
    Position<K> prev(Position<K> p);
    Position<K> above(Position<K> p);
    Position<K> below(Position<K> p);
    /** Returns position with the largest key that is less or equal to the specified key. */
    Position<K> search(K key);
}

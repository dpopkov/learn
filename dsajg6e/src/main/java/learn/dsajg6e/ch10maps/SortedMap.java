package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

public interface SortedMap<K, V> extends Map<K, V> {
    /** Returns an entry with smallest key value (or null, if the map is empty). */
    Entry<K, V> firstEntry();

    /** Returns the entry with largest key value (or null, if the map is empty). */
    Entry<K, V> lastEntry();

    /** Returns the entry with the least key greater than or equal to the specified key
        (or null, if no such entry exists). */
    Entry<K, V> ceilingEntry(K key);

    /** Returns the entry with the greatest key less than or equal to the specified key
        (or null, if no such entry exists). */
    Entry<K, V> floorEntry(K key);

    /** Returns the entry with the greatest key strictly less than the specified key
        (or null, if no such entry exists). */
    Entry<K, V> lowerEntry(K key);

    /** Returns the entry with the lowest key strictly greater than the specified key
        (or null, if no such entry exists). */
    Entry<K, V> higherEntry(K key);

    /** Returns an iteration of all entries with key greater than or equal to key1,
        but strictly less than key2. */
    Iterable<Entry<K, V>> subMap(K key1, K key2);
}

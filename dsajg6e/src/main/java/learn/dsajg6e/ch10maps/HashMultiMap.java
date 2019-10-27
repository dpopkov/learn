package learn.dsajg6e.ch10maps;

import java.util.*;
import java.util.Map;

@SuppressWarnings("unused")
public class HashMultiMap<K, V> {
    @SuppressWarnings("rawtypes")
    private static final List EMPTY_LIST = Collections.emptyList();

    /** The primary map. */
    private final Map<K, List<V>> map = new HashMap<>();
    /** Total number of entries in the multi-map. */
    private int total;

    /** Returns the total number of entries in the multi-map. */
    public int size() {
        return total;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    @SuppressWarnings("unchecked")
    public Iterable<V> get(K key) {
        List<V> secondary = map.get(key);
        return secondary != null ? secondary : (List<V>) EMPTY_LIST;
    }

    /** Adds a new entry associating key with the value. */
    public void put(K key, V value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        total++;
    }

    /** Removes the key-value entry if it exists. */
    public boolean remove(K key, V value) {
        boolean removed = false;
        List<V> secondary = map.get(key);
        if (secondary != null) {
            removed = secondary.remove(value);
            if (removed) {
                total--;
                if (secondary.isEmpty()) {
                    map.remove(key);
                }
            }
        }
        return removed;
    }

    @SuppressWarnings("unchecked")
    public Iterable<V> removeAll(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null) {
            total -= secondary.size();
            map.remove(key);
        } else {
            secondary = (List<V>) EMPTY_LIST;
        }
        return secondary;
    }

    /** Returns an iteration of all entries in the multi-map. */
    public Iterable<Map.Entry<K, V>> entries() {
        List<Map.Entry<K, V>> result = new ArrayList<>();
        for (Map.Entry<K, List<V>> secondary : map.entrySet()) {
            K key = secondary.getKey();
            for (V value : secondary.getValue()) {
                result.add(new java.util.AbstractMap.SimpleEntry<>(key, value));
            }
        }
        return result;
    }
}

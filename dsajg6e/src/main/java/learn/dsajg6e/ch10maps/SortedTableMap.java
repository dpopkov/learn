package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class SortedTableMap<K, V> extends AbstractSortedMap<K, V> {
    private final ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public SortedTableMap(Comparator<K> comparator) {
        super(comparator);
    }

    public SortedTableMap() {
        super();
    }

    /**
     * Returns the smallest index for range table[low..high] inclusive storing an entry
     * with a key greater than or equal to the key (or else index high + 1, by convention).
     */
    @SuppressWarnings("SameParameterValue")
    private int findIndex(K key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = compare(key, table.get(mid));
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high + 1;
    }

    /** Version of findIndex that searches the entire table. */
    private int findIndex(K key) {
        return findIndex(key, 0, table.size() - 1);
    }

    @Override
    public Entry<K, V> firstEntry() {
        return safeEntry(0);
    }

    @Override
    public Entry<K, V> lastEntry() {
        return safeEntry(table.size() - 1);
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return safeEntry(findIndex(key));
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        int j = findIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) {
            j--;
        }
        return safeEntry(j);
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        return safeEntry(findIndex(key) - 1);
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        int j = findIndex(key);
        if (j < size() && key.equals(table.get(j).getKey())) {
            j++;
        }
        return safeEntry(j);
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int j = findIndex(key);
        if (j == size() || compare(key, table.get(j)) != 0) {
            return null;
        }
        return table.get(j).getValue();
    }

    @Override
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j < size() && compare(key, table.get(j)) == 0) {
            return table.get(j).setValue(value);
        }
        table.add(j, new MapEntry<>(key, value));
        return null;
    }

    @Override
    public V remove(K key) {
        int j = findIndex(key);
        if (j < size() && compare(key, table.get(j)) == 0) {
            return table.remove(j).getValue();
        }
        return null;
    }

    /** Returns the entry at index j, or else null if j is out of bounds. */
    private Entry<K, V> safeEntry(int j) {
        if (j < 0 || j >= table.size()) {
            return null;
        }
        return table.get(j);
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return snapshot(0, null);
    }

    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
        return snapshot(findIndex(fromKey), toKey);
    }

    private Iterable<Entry<K, V>> snapshot(int startIdx, K stop) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        int j = startIdx;
        while (j < table.size() && (stop == null || compare(stop, table.get(j)) > 0)) {
            buffer.add(table.get(j));
            j++;
        }
        return buffer;
    }
}

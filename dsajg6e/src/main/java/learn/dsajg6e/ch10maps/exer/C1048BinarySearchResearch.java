package learn.dsajg6e.ch10maps.exer;

/*
Uses algorithm from CF-10.11 (SortedTableMap).
 */
public class C1048BinarySearchResearch<K extends Comparable<K>> {
    private final K[] keys;

    public C1048BinarySearchResearch(K[] keys) {
        this.keys = keys;
    }

    /**
     * Returns the smallest index storing a key
     * greater than or equal to the specified key.
     */
    public int findIndex(K key) {
        int low = 0;
        int high = keys.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            K k = keys[mid];
            if (k.equals(key)) {
                return mid;
            } else if (k.compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1;
    }


}

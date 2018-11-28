package learn.dsai.ch06rec;

import java.util.StringJoiner;

public class OrdArray {
    private final long[] arr;
    private int size;

    public OrdArray(int capacity) {
        arr = new long[capacity];
    }

    public void insert(long value) {
        int i;
        for (i = size; i > 0 && arr[i - 1] > value; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = value;
        size++;
    }

    /**
     * Finds index of the specified value
     * @param value value to find
     * @return index of the found value or negative number equal to {@code (-pos - 1)}
     *          where {@code pos} is the index where this value could be inserted
     */
    public int indexOf(long value) {
        return recursiveFind(value, 0, size - 1);
    }

    private int recursiveFind(long key, int lower, int upper) {
        if (lower > upper) {
            return -lower - 1;
        }
        int mid = lower + (upper - lower) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (key < arr[mid]) {
            return recursiveFind(key, lower, mid - 1);
        } else {
            return recursiveFind(key, lower + 1, upper);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(Long.toString(arr[i]));
        }
        return joiner.toString();
    }
}

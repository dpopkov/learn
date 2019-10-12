package learn.dsajg6e.ch09pq2.exer;

import java.util.Comparator;

public class C0942BinarySearch<E> {
    private final E[] array;
    private final Comparator<E> comparator;

    public C0942BinarySearch(E[] array, Comparator<E> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    public int search(E e) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = comparator.compare(e, array[mid]);
            if (r == 0) {
                return mid;
            } else if (r < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

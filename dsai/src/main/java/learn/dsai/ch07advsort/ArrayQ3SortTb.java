package learn.dsai.ch07advsort;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates improved version of quick sort that uses insertion sort for cleanup.
 * Textbook implementation.
 */
@SuppressWarnings("StatementWithEmptyBody")
public class ArrayQ3SortTb extends ArrayLong {
    public ArrayQ3SortTb(int max) {
        super(max);
    }

    @Override
    public void sort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size < 10) {
            insertionSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            long m = a[i];
            int j;
            for (j = i; j > left && a[j - 1] > m; j--) {
                a[j] = a[j - 1];
            }
            a[j] = m;
        }
    }

    /* Median partitioning requires at least 4 cells. */
    private long medianOf3(int left, int right) {
        int m = left + (right - left) / 2;
        if (a[left] > a[m]) {
            swap(left, m);
        }
        if (a[left] > a[right]) {
            swap(left, right);
        }
        if (a[m] > a[right]) {
            swap(m, right);
        }
        swap(m, right - 1);
        return a[right - 1];
    }

    @SuppressWarnings("Duplicates")
    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (a[++leftPtr] < pivot) ; // nop
            while (a[--rightPtr] > pivot) ; // nop
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }
}

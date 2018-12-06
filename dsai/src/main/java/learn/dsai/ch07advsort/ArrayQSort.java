package learn.dsai.ch07advsort;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates simple version of quick sort.
 */
@SuppressWarnings("StatementWithEmptyBody")
public class ArrayQSort extends ArrayLong {
    public ArrayQSort(int max) {
        super(max);
    }

    @Override
    public void sort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        long pivot = a[right];
        int partition = partitionIt(left, right - 1, pivot);
        swap(partition, right);
        recQuickSort(left, partition - 1);
        recQuickSort(partition + 1, right - 1);
    }

    /* Textbook implementation. */
    @SuppressWarnings("unused")
    private void recQuickSort2(int left, int right) {
        if (right - left <= 0) {
            return;
        }
        long pivot = a[right];
        int partition = partitionIt2(left, right, pivot);
        recQuickSort2(left, partition - 1);
        recQuickSort2(partition + 1, right);
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (a[++leftPtr] < pivot) ; // nop
            while (rightPtr > left && a[--rightPtr] > pivot) ; // nop
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    /* Textbook implementation */
    private int partitionIt2(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (a[++leftPtr] < pivot) ; // nop
            while (rightPtr > 0 && a[--rightPtr] > pivot) ; // nop
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }
}

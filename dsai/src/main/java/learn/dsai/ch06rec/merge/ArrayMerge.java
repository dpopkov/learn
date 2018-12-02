package learn.dsai.ch06rec.merge;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates merge sort.
 */
public class ArrayMerge extends ArrayLong {

    public ArrayMerge(int max) {
        super(max);
    }

    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    private void recMergeSort(long[] workSpace, int lower, int upper) {
        if (lower < upper) {
            int mid = (lower + upper) / 2;
            recMergeSort(workSpace, lower, mid);
            recMergeSort(workSpace, mid + 1, upper);
            merge(workSpace, lower, mid + 1, upper);
            System.arraycopy(workSpace, lower, a, lower, upper - lower + 1);
        }
    }

    @SuppressWarnings("Duplicates")
    private void merge(long[] workSpace, int lower, int mid, int upper) {
        int i = lower;
        int i1 = lower, i2 = mid;
        while (i1 < mid && i2 <= upper) {
            if (a[i1] < a[i2]) {
                workSpace[i++] = a[i1++];
            } else {
                workSpace[i++] = a[i2++];
            }
        }
        while (i1 < mid) {
            workSpace[i++] = a[i1++];
        }
        while (i2 <= upper) {
            workSpace[i++] = a[i2++];
        }
    }

    @Override
    public void sort() {
        mergeSort();
    }
}

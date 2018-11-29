package learn.dsai.ch06rec.merge;

/**
 * Demonstrates recursive merge sort.
 */
public class MergeSort {
    private final long[] values;

    public MergeSort(long[] values) {
        this.values = values;
    }

    public void sort() {
        long[] workSpace = new long[values.length];
        recMergeSort(workSpace, 0, values.length - 1);
    }

    private void recMergeSort(long[] workSpace, int lower, int upper) {
        if (lower == upper) {
            return;
        }
        if (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            recMergeSort(workSpace, lower, mid);
            recMergeSort(workSpace, mid + 1, upper);
            merge(workSpace, lower, mid + 1, upper);
            System.arraycopy(workSpace, lower, values, lower, upper - lower + 1);
        }
    }

    void merge(long[] workSpace, int lower, int mid, int upper) {
        int i = lower;
        int i1 = lower, i2 = mid;
        while (i1 < mid && i2 <= upper) {
            if (values[i1] < values[i2]) {
                workSpace[i++] = values[i1++];
            } else {
                workSpace[i++] = values[i2++];
            }
        }
        while (i1 < mid) {
            workSpace[i++] = values[i1++];
        }
        while (i2 <= upper) {
            workSpace[i++] = values[i2++];
        }
    }
}

package learn.dsai.ch07advsort.projects;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates improved version of quick sort that uses 'median-of-three' pivot value.
 * Textbook implementation.
 * Counts the number of copies and comparisons.
 */
@SuppressWarnings("StatementWithEmptyBody")
public class P0702ArrayQ2SortTb extends ArrayLong {
    private int numCopies;
    private int numComparisons;

    public P0702ArrayQ2SortTb(int max) {
        super(max);
    }

    public void displayStats() {
        System.out.println("numCopies      = " + numCopies);
        System.out.println("numComparisons = " + numComparisons);
    }

    @Override
    public void sort() {
        recQuickSort(0, nElems - 1);
    }

    @SuppressWarnings("Duplicates")
    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    /** Manual sorting of sub-arrays of length 3 or less. */
    @SuppressWarnings("Duplicates")
    void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size == 2) {
            if (a[left] > a[right]) {
                swap(left, right);
            }
            numComparisons++;
        } else if (size == 3) {
            int m = left + 1;
            if (a[left] > a[m]) {
                swap(left, m);
            }
            if (a[m] > a[right]) {
                swap(m, right);
            }
            if (a[left] > a[m]) {
                swap(left, m);
            }
            numComparisons += 3;
        }
        // else size == 1
    }

    /* Median partitioning requires at least 4 cells. */
    @SuppressWarnings("Duplicates")
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
        numComparisons += 3;
        swap(m, right - 1);
        return a[right - 1];
    }

    @SuppressWarnings("Duplicates")
    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (a[++leftPtr] < pivot) {
                numComparisons++;
            }
            while (a[--rightPtr] > pivot) {
                numComparisons++;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    @Override
    protected void swap(int j, int i) {
        super.swap(j, i);
        numCopies += 3;
    }
}

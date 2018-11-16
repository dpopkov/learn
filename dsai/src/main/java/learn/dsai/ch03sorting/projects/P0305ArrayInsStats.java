package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayLong;

/**
 * Demonstrates insertion sort.
 * Counts the number of copies and the number of comparisons.
 */
public class P0305ArrayInsStats extends ArrayLong {

    public P0305ArrayInsStats(int max) {
        super(max);
    }

    public void insertionSort() {
        int numComparisons = 0;
        int numCopies = 0;
        for (int m = 1; m < nElems; m++) {
            long current = a[m];
            int i = m;
            while (i > 0) {
                numComparisons++;
                if (a[i - 1] > current) {
                    a[i] = a[i - 1];
                    numCopies++;
                    i--;
                } else {
                    break;
                }
            }
            if (i != m) {
                a[i] = current;
                numCopies++;
            }
        }
        System.out.println("numComparisons = " + numComparisons);
        System.out.println("numCopies = " + numCopies);
    }

    @Override
    public void sort() {
        insertionSort();
    }
}

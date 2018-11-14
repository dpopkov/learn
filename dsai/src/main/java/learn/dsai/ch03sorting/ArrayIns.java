package learn.dsai.ch03sorting;

/**
 * Demonstrates insertion sort.
 */
public class ArrayIns extends ArrayLong {

    public ArrayIns(int max) {
        super(max);
    }

    public void insertionSort() {
        for (int m = 1; m < nElems; m++) {
            long current = a[m];
            int i = m;
            while (i > 0 && a[i - 1] > current) {
                a[i] = a[i - 1];
                i--;
            }
            a[i] = current;
        }
    }

    @Override
    public void sort() {
        insertionSort();
    }
}

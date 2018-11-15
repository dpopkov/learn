package learn.dsai.ch03sorting;

/**
 * Demonstrates selection sort.
 */
public class ArraySel extends ArrayLong {

    public ArraySel(int max) {
        super(max);
    }

    public void selectionSort() {
        for (int i = 0; i < nElems - 1; i++) {
            int min = i;
            for (int j = min + 1; j < nElems; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(i, min);
            }
        }
    }

    @Override
    public void sort() {
        selectionSort();
    }
}

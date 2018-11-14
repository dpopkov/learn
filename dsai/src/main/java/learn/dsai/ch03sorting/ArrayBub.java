package learn.dsai.ch03sorting;

/**
 * Demonstrates bubble sort.
 */
public class ArrayBub extends ArrayLong {

    public ArrayBub(int max) {
        super(max);
    }

    public void bubbleSort() {
        for (int last = nElems - 1; last > 0; last--) {
            for (int j = 0; j < last; j++) {
                if (a[j] > a[j + 1]) {
                    swapNext(j);
                }
            }
        }
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    private void swapNext(int j) {
        int next = j + 1;
        long t = a[j];
        a[j] = a[next];
        a[next] = t;
    }
}

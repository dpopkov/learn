package learn.dsai.ch03sorting;

import learn.dsai.tools.ArrayTools;

/**
 * Demonstrates selection sort.
 */
public class ArraySel {
    private final long[] a;
    private int nElems;

    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
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

    private void swap(int j, int k) {
        long t = a[j];
        a[j] = a[k];
        a[k] = t;
    }
}

package learn.dsai.ch03sorting;

import learn.dsai.tools.ArrayTools;

/**
 * Demonstrates insertion sort.
 */
public class ArrayIns {
    private final long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
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
}

package learn.dsai.ch03sorting;

import learn.dsai.tools.ArrayTools;

/**
 * Demonstrates bubble sort.
 */
public class ArrayBub {
    private final long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
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

    private void swapNext(int j) {
        int next = j + 1;
        long t = a[j];
        a[j] = a[next];
        a[next] = t;
    }
}

package learn.dsai.ch03sorting;

import learn.dsai.tools.ArrayTools;

public abstract class ArrayLong {
    protected final long[] a;
    protected int nElems;

    public ArrayLong(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
    }

    public abstract void sort();
}

package learn.dsai.ch03sorting;

import learn.dsai.tools.ArrayTools;

public abstract class ArrayLong {
    protected final long[] a;
    protected int nElems;

    public ArrayLong(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean isNotFull() {
        return nElems < a.length;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public long get(int index) {
        return a[index];
    }

    public int getSize() {
        return nElems;
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
    }

    @Override
    public String toString() {
        return ArrayTools.toString(a, nElems);
    }

    public abstract void sort();

    protected void swap(int j, int i) {
        long t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    public void copyTo(ArrayLong dest) {
        if (dest.a.length < this.a.length) {
            throw new IllegalArgumentException("Destination array wrapper has not enough capacity");
        }
        for (long value : a) {
            dest.insert(value);
        }
    }
}

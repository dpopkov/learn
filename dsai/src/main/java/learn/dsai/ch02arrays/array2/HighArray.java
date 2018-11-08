package learn.dsai.ch02arrays.array2;

import learn.dsai.tools.ArrayTools;

public class HighArray {
    private final long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public boolean find(long key) {
        boolean found = false;
        for (int i = 0; i < nElems; i++) {
            if (a[i] == key) {
                found = true;
                break;
            }
        }
        return found;
    }

    @SuppressWarnings("ManualArrayCopy")
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    @Override
    public String toString() {
        return ArrayTools.toString(a, nElems);
    }

    public void display() {
        System.out.println(ArrayTools.toString(a, nElems));
    }
}

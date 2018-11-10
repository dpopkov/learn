package learn.dsai.ch02arrays.array2;

import learn.dsai.tools.ArrayTools;

public class HighArray {
    private static final int INDEX_OF_NOT_FOUND = -1;

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
        return findIndex(key) != INDEX_OF_NOT_FOUND;
    }

    public boolean delete(long value) {
        int j = findIndex(value);
        if (j == INDEX_OF_NOT_FOUND) {
            return false;
        } else {
            removeAtIndex(j);
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

    public int getSize() {
        return nElems;
    }

    public long getMax() {
        long rsl = -1;
        for (int i = 0; i < nElems; i++) {
            if(a[i] > rsl) {
                rsl = a[i];
            }
        }
        return rsl;
    }

    public long removeMax() {
        if (nElems == 0) {
            return -1L;
        }
        int iMax = 0;
        for (int i = 1; i < nElems; i++) {
            if (a[i] > a[iMax]) {
                iMax = i;
            }
        }
        long maxValue = a[iMax];
        removeAtIndex(iMax);
        return maxValue;
    }

    private int findIndex(long key) {
        for (int i = 0; i < nElems; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return INDEX_OF_NOT_FOUND;
    }

    @SuppressWarnings("ManualArrayCopy")
    private void removeAtIndex(int index) {
        for (int k = index; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
    }

    @SuppressWarnings("ManualArrayCopy")
    public void noDuplicates() {
        int last = nElems - 1;
        for (int i = 1; i <= last;) {
            if (hasDuplicatesBefore(i)) {
                int newLast = swapWithNonDuplicate(i, last);
                int numDeleted = last - newLast + 1;
                nElems -= numDeleted;
                last = newLast - 1;
            } else {
                i++;
            }
        }
    }

    private int swapWithNonDuplicate(int i, int j) {
        while (j > i && a[j] == a[i]) {
            j--;
        }
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
        return j;
    }

    private boolean hasDuplicatesBefore(int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (a[i] == a[index]) {
                return true;
            }
        }
        return false;
    }
}

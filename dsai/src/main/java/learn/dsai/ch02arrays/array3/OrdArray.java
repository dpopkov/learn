package learn.dsai.ch02arrays.array3;

import learn.dsai.tools.ArrayTools;

@SuppressWarnings("ManualArrayCopy")
public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public void insert(long value) {
        int i;
        for (i = nElems; i > 0 && a[i - 1] > value; i--) {
            a[i] = a[i - 1];
        }
        a[i] = value;
        nElems++;
    }

    public int find(long key) {
        int low = 0;
        int high = nElems - 1;
        int pos = 0;
        while (low <= high) {
            pos = low + (high - low) / 2;
            if (a[pos] == key) {
                return pos;
            } else if (key < a[pos]) {
                high = pos - 1;
            } else {
                low = pos + 1;
            }
        }
        return -pos - 1;
    }

    public boolean delete(long value) {
        int pos = find(value);
        if (pos < 0) {
            return false;
        } else {
            for (int i = pos; i < nElems - 1; i++) {
                a[i] = a[i + 1];
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
        System.out.println(this.toString());
    }
}

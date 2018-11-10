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
        int pos = find(value);
        pos = (pos < 0) ? -(pos + 1) : pos;
        for (int i = nElems; i > pos; i--) {
            a[i] = a[i - 1];
        }
        a[pos] = value;
        nElems++;
    }

    public int find(long key) {
        int low = 0;
        int high = nElems - 1;
        int pos;
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
        return -low - 1;
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

    private void add(long value) {
        a[nElems++] = value;
    }

    public static OrdArray merge(OrdArray left, OrdArray right) {
        int capacity = left.nElems + right.nElems;
        int iLeft = 0, iRight = 0;
        OrdArray result = new OrdArray(capacity);
        for (int i = 0; i < capacity; i++) {
            if (iLeft < left.nElems && iRight < right.nElems) {
                if (left.a[iLeft] < right.a[iRight]) {
                    result.add(left.a[iLeft++]);
                } else {
                    result.add(right.a[iRight++]);
                }
            } else if (iLeft < left.nElems) {
                result.add(left.a[iLeft++]);
            } else if (iRight < right.nElems) {
                result.add(right.a[iRight++]);
            }
        }
        return result;
    }
}

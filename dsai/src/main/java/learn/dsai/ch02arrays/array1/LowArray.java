package learn.dsai.ch02arrays.array1;

import learn.dsai.tools.ArrayTools;

public class LowArray {
    private final long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) throws ArrayIndexOutOfBoundsException {
        return a[index];
    }

    public String toString(int length) {
        return ArrayTools.toString(a, length);
    }
}

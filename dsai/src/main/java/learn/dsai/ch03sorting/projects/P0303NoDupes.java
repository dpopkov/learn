package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayIns;

public class P0303NoDupes extends ArrayIns {

    public P0303NoDupes(int max) {
        super(max);
    }

    public void noDupes() {
        sort();
        int last = nElems - 1;
        long[] buffer = new long[a.length];
        buffer[0] = a[0];
        int bufferElems = 1;
        for (int i = 1; i <= last; i++) {
            if (a[i - 1] != a[i]) {
                buffer[bufferElems++] = a[i];
            }
        }
        System.arraycopy(buffer, 0, a, 0, bufferElems);
        nElems = bufferElems;
    }

    public void noDupesInPlace() {
        final int notExistingValue = Integer.MIN_VALUE;
        sort();
        int comp = 0;
        for (int i = 1; i < nElems; i++) {
            if (a[comp] == a[i]) {
                a[i] = notExistingValue;
            } else {
                comp = i;
            }
        }
        int newNumElems = 1;
        int shifted = 0;
        for (int i = 1; i < nElems; i++) {
            if (a[i] == notExistingValue) {
                shifted++;
            } else {
                if (shifted > 0) {
                    a[i - shifted] = a[i];
                }
                newNumElems++;
            }
        }
        nElems = newNumElems;
    }
}

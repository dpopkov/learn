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
}

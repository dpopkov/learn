package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayIns;

/**
 * Removes duplicates from an array as it sorts.
 */
public class P0306RemoveDuplicates extends ArrayIns {
    public static final long NON_EXISTING = -1;

    public P0306RemoveDuplicates(int max) {
        super(max);
    }

    public void removeDuplicates() {
        for (int m = 1; m < nElems; m++) {
            long current = a[m];
            int i = m;
            while (i > 0) {
                if (a[i - 1] == NON_EXISTING || a[i - 1] < current) {
                    break;
                } else if (a[i - 1] == current) {
                    current = NON_EXISTING;
                } else if (a[i - 1] > current) {
                    a[i] = a[i - 1];
                    i--;
                }
            }
            a[i] = current;
        }
        trimNonExisting();
    }

    private void trimNonExisting() {
        int trimLength = 0;
        for (int i = 0; i < nElems && a[i] == NON_EXISTING; i++) {
            trimLength++;
        }
        int newNumElems = nElems - trimLength;
        System.arraycopy(a, trimLength, a, 0, newNumElems);
        nElems = newNumElems;
    }
}

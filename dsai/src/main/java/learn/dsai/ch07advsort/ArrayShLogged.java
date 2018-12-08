package learn.dsai.ch07advsort;

import learn.dsai.ch03sorting.ArrayLong;

public class ArrayShLogged extends ArrayLong {
    private final boolean logging;

    public ArrayShLogged(int max) {
        this(max, true);
    }

    public ArrayShLogged(int max, boolean logging) {
        super(max);
        this.logging = logging;
    }

    @Override
    public void sort() {
        shellSort();
    }

    private void shellSort() {
        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < nElems; i++) {
                long m = a[i];
                int j = i;
                while (j > h - 1 && a[j - h] > m) {
                    a[j] = a[j - h];
                    j -= h;
                }
                a[j] = m;
                if (logging) {
                    display();
                }
            }
            h = (h - 1) / 3;
        }
    }
}

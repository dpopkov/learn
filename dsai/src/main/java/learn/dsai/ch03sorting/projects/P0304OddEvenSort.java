/*
The idea is to repeatedly make two passes through the array.
On the first pass you look at all the pairs of items,
a[j] and a[j+1], where j is odd (j = 1, 3, 5, ...). If their key values
are out of order, then swap them. On the second pass you do the same for all
the even values (j = 2, 4, 6, ...). You do these two passes repeatedly until
the array is sorted.
 */
package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayIns;

public class P0304OddEvenSort extends ArrayIns {
    public P0304OddEvenSort(int max) {
        super(max);
    }

    @Override
    public void sort() {
        sortOddEven();
    }

    public void sortOddEven() {
        boolean oddSort = true;
        boolean evenSort = true;
        while (oddSort || evenSort) {
            oddSort = false;
            for (int i = 1; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    oddSort = true;
                }
            }
            evenSort = false;
            for (int i = 0; i < nElems - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    evenSort = true;
                }
            }
        }
    }
}

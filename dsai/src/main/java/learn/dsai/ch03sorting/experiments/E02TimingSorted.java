package learn.dsai.ch03sorting.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E02TimingSorted {
    private final static int MAX_SIZE = 100000;

    public static void main(String[] args) {
        sortSorted(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortSorted(new ArraySel(MAX_SIZE), "ArraySel");
        sortSorted(new ArrayIns(MAX_SIZE), "ArrayIns");
    }
    /*
    Results 2018-11-15 (on size 100000):
    ArrayBub finished in 1903 milliseconds
    ArraySel finished in 1822 milliseconds
    ArrayIns finished in 3 milliseconds
     */

    private static void sortSorted(ArrayLong arr, String label) {
        fillAndSort(arr, E02TimingSorted::fillSorted, label);
    }

    private static void fillSorted(ArrayLong arr) {
        long value = 1;
        while (value <= MAX_SIZE) {
            arr.insert(value++);
        }
    }
}

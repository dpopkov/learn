package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;
import learn.dsai.ch07advsort.ArraySh;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E03TimingSorted {
    private final static int MAX_SIZE = 100_000;

    public static void main(String[] args) {
        sorSorted(new ArrayBub(MAX_SIZE), "ArrayBub");
        sorSorted(new ArraySel(MAX_SIZE), "ArraySel");
        sorSorted(new ArrayIns(MAX_SIZE), "ArrayIns");
        sorSorted(new ArrayMerge(MAX_SIZE), "ArrayMerge");
        sorSorted(new ArraySh(MAX_SIZE), "ArraySh");
    }
    /*
    Results 2018-12-04:
    ArrayBub   finished in  2078 milliseconds
    ArraySel   finished in  1886 milliseconds
    ArrayIns   finished in     2 milliseconds
    ArrayMerge finished in     8 milliseconds
    ArraySh    finished in     3 milliseconds
     */

    private static void sorSorted(ArrayLong arr, String label) {
        fillAndSort(arr, E03TimingSorted::fillSorted, label);
    }

    private static void fillSorted(ArrayLong arr) {
        long value = 1;
        while (value <= MAX_SIZE) {
            arr.insert(value++);
        }
    }
}

package learn.dsai.ch03sorting.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E02TimingInversed {
    private final static int MAX_SIZE = 100000;

    public static void main(String[] args) {
        sortInversed(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortInversed(new ArraySel(MAX_SIZE), "ArraySel");
        sortInversed(new ArrayIns(MAX_SIZE), "ArrayIns");
    }
    /*
    Results 2018-11-15:
    ArrayBub finished in 4185 milliseconds
    ArraySel finished in 6231 milliseconds
    ArrayIns finished in 2481 milliseconds
     */

    private static void sortInversed(ArrayLong arr, String label) {
        fillAndSort(arr, E02TimingInversed::fillInversed, label);
    }

    private static void fillInversed(ArrayLong arr) {
        long value = MAX_SIZE;
        while (value > 0) {
            arr.insert(value--);
        }
    }
}

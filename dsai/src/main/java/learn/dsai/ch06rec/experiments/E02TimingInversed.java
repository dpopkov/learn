package learn.dsai.ch06rec.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E02TimingInversed {
    private final static int MAX_SIZE = 100_000;

    public static void main(String[] args) {
        sortInversed(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortInversed(new ArraySel(MAX_SIZE), "ArraySel");
        sortInversed(new ArrayIns(MAX_SIZE), "ArrayIns");
        sortInversed(new ArrayMerge(MAX_SIZE), "ArrayMerge");
    }
    /*
    Results 2018-12-02:
    ArrayBub   finished in  4007 milliseconds
    ArraySel   finished in  4691 milliseconds
    ArrayIns   finished in  2315 milliseconds
    ArrayMerge finished in     7 milliseconds
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

package learn.dsai.ch06rec.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;

import java.util.Random;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E01TimingRandom {
    private final static int MAX_SIZE = 100_000;

    public static void main(String[] args) {
        sortRandom(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortRandom(new ArraySel(MAX_SIZE), "ArraySel");
        sortRandom(new ArrayIns(MAX_SIZE), "ArrayIns");
        sortRandom(new ArrayMerge(MAX_SIZE), "ArrayMerge");
    }
    /*
    Results 2018-12-02:
    ArrayBub   finished in 21284 milliseconds
    ArraySel   finished in  5147 milliseconds
    ArrayIns   finished in  1129 milliseconds
    ArrayMerge finished in    14 milliseconds
     */

    private static void sortRandom(ArrayLong arr, String label) {
        fillAndSort(arr, E01TimingRandom::fillRandom, label);
    }

    private static void fillRandom(ArrayLong arr) {
        Random random = new Random();
        while (arr.isNotFull()) {
            arr.insert(random.nextLong());
        }
    }
}

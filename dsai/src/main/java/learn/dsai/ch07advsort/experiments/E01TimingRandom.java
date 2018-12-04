package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;
import learn.dsai.ch07advsort.ArraySh;

import java.util.Random;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E01TimingRandom {
    private final static int MAX_SIZE = 100_000;

    public static void main(String[] args) {
        sortRandom(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortRandom(new ArraySel(MAX_SIZE), "ArraySel");
        sortRandom(new ArrayIns(MAX_SIZE), "ArrayIns");
        sortRandom(new ArrayMerge(MAX_SIZE), "ArrayMerge");
        sortRandom(new ArraySh(MAX_SIZE), "ArraySh");
    }
    /*
    Results 2018-12-04:
    ArrayBub   finished in 21638 milliseconds
    ArraySel   finished in  5223 milliseconds
    ArrayIns   finished in  1151 milliseconds
    ArrayMerge finished in    15 milliseconds
    ArraySh    finished in    19 milliseconds
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

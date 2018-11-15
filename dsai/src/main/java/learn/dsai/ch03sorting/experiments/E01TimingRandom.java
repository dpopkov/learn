package learn.dsai.ch03sorting.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;

import java.util.Random;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class E01TimingRandom {
    private final static int MAX_SIZE = 100000;

    public static void main(String[] args) {
        sortRandom(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortRandom(new ArraySel(MAX_SIZE), "ArraySel");
        sortRandom(new ArrayIns(MAX_SIZE), "ArrayIns");
    }
    /*
    Results 2018-11-15:
    ArrayBub finished in 21322 milliseconds
    ArraySel finished in  6054 milliseconds
    ArrayIns finished in  1121 milliseconds
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

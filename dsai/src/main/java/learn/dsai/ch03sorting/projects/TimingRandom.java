package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;

import java.util.Random;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

public class TimingRandom {
    private final static int MAX_SIZE = 20000;

    public static void main(String[] args) {
        sortRandom(new ArrayBub(MAX_SIZE), "ArrayBub");
        sortRandom(new P0301BidirectionalBubble(MAX_SIZE), "BidirectionalBubble");
        sortRandom(new P0304OddEvenSort(MAX_SIZE), "OddEvenSort");
        sortRandom(new ArraySel(MAX_SIZE), "ArraySel");
        sortRandom(new ArrayIns(MAX_SIZE), "ArrayIns");
    }
    /*
    Results 2018-11-15 (on size 20000):
    ArrayBub finished in 939 milliseconds
    BidirectionalBubble finished in 522 milliseconds
    OddEvenSort finished in 430 milliseconds
    ArraySel finished in 216 milliseconds
    ArrayIns finished in 45 milliseconds
     */

    private static void sortRandom(ArrayLong arr, String label) {
        fillAndSort(arr, TimingRandom::fillRandom, label);
    }

    private static void fillRandom(ArrayLong arr) {
        Random random = new Random();
        while (arr.isNotFull()) {
            arr.insert(random.nextLong());
        }
    }
}

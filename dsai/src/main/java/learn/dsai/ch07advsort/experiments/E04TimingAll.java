package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;
import learn.dsai.ch07advsort.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class E04TimingAll {
    private final static int MAX_SIZE = 100_000; // a value of 20_000 and more causes StackOverflowError
                                                // in experiment with fillSorted in ArrayQSort.recQuickSort()
    private static final List<IntFunction<? extends ArrayLong>> constructors = Arrays.asList(
            /*ArrayBub::new,*/
            ArraySel::new,
            ArrayIns::new,
            ArrayMerge::new,
            ArraySh::new,
            /*ArrayQSort::new,*/
            ArrayQ2SortTb::new/*,
            ArrayQ2Sort::new*/,
            ArrayQ3SortTb::new
    );

    public static void main(String[] args) {
        String[] titles = {
                "Sorting random data",
                "Sorting inversed data",
                "Sorting sorted data"
        };
        List<Consumer<ArrayLong>> fillers = Arrays.asList(
                E04TimingAll::fillRandom,
                E04TimingAll::fillInversed,
                E04TimingAll::fillSorted
        );
        for (int i = 0; i < titles.length; i++) {
            SortingExperiment experiment = new SortingExperiment(titles[i], constructors,
                    MAX_SIZE, fillers.get(i));
            experiment.run();
        }
    }

    private static void fillRandom(ArrayLong arr) {
        Random random = new Random();
        while (arr.isNotFull()) {
            arr.insert(random.nextLong());
        }
    }

    private static void fillInversed(ArrayLong arr) {
        long value = arr.getMaxCapacity();
        while (arr.isNotFull()) {
            arr.insert(value--);
        }
    }

    private static void fillSorted(ArrayLong arr) {
        long value = 1;
        while (arr.isNotFull()) {
            arr.insert(value++);
        }
    }
}

/*
Results 2018-12-08 (on size 100_000):
------------------------------------
Sorting random data
ArraySel       finished in  6349 milliseconds
ArrayIns       finished in  1157 milliseconds
ArrayMerge     finished in    15 milliseconds
ArraySh        finished in    21 milliseconds
ArrayQ2SortTb  finished in    15 milliseconds
ArrayQ3SortTb  finished in    14 milliseconds
Sorting inversed data
ArraySel       finished in  6001 milliseconds
ArrayIns       finished in  2408 milliseconds
ArrayMerge     finished in     4 milliseconds
ArraySh        finished in     4 milliseconds
ArrayQ2SortTb  finished in     3 milliseconds
ArrayQ3SortTb  finished in     2 milliseconds
Sorting sorted data
ArraySel       finished in  3043 milliseconds
ArrayIns       finished in     0 milliseconds
ArrayMerge     finished in     4 milliseconds
ArraySh        finished in     2 milliseconds
ArrayQ2SortTb  finished in     3 milliseconds
ArrayQ3SortTb  finished in     2 milliseconds
 */

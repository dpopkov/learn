package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;
import learn.dsai.ch07advsort.ArrayQSort;
import learn.dsai.ch07advsort.ArraySh;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class E04TimingAll {
    private final static int MAX_SIZE = 10_000; // a value of 20_000 causes StackOverflowError
                                                // in experiment with fillSorted in ArrayQSort.recQuickSort()
    private static final List<IntFunction<? extends ArrayLong>> constructors = Arrays.asList(
            ArrayBub::new,
            ArraySel::new,
            ArrayIns::new,
            ArrayMerge::new,
            ArraySh::new,
            ArrayQSort::new
    );

    public static void main(String[] args) {
        String[] titles = {
                "Sorting random data:",
                "Sorting inversed data:",
                "Sorting sorted data:"
        };
        List<Consumer<ArrayLong>> fillers = Arrays.asList(
                E04TimingAll::fillRandom,
                E04TimingAll::fillInversed,
                E04TimingAll::fillSorted
        );
        for (int i = 0; i < titles.length; i++) {
            SortingExperiment experiment = new SortingExperiment(titles[i], constructors,
                    MAX_SIZE, fillers.get(i));
            experiment.start();
            try {
                experiment.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
Results 2018-12-06 (on size 10_000):
------------------------------------
Sorting random data:
ArrayBub   finished in   236 milliseconds
ArraySel   finished in    62 milliseconds
ArrayIns   finished in    17 milliseconds
ArrayMerge finished in     3 milliseconds
ArraySh    finished in     5 milliseconds
ArrayQSort finished in     2 milliseconds
Sorting inversed data:
ArrayBub   finished in   107 milliseconds
ArraySel   finished in    57 milliseconds
ArrayIns   finished in    26 milliseconds
ArrayMerge finished in     0 milliseconds
ArraySh    finished in     1 milliseconds
ArrayQSort finished in    10 milliseconds
Sorting sorted data:
ArrayBub   finished in    63 milliseconds
ArraySel   finished in    61 milliseconds
ArrayIns   finished in     0 milliseconds
ArrayMerge finished in     1 milliseconds
ArraySh    finished in     0 milliseconds
ArrayQSort finished in    94 milliseconds
 */

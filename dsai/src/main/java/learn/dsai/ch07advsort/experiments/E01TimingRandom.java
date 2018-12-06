package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayBub;
import learn.dsai.ch03sorting.ArrayIns;
import learn.dsai.ch03sorting.ArrayLong;
import learn.dsai.ch03sorting.ArraySel;
import learn.dsai.ch06rec.merge.ArrayMerge;
import learn.dsai.ch07advsort.ArraySh;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

public class E01TimingRandom {
    private final static int MAX_SIZE = 20_000;

    private static List<IntFunction<? extends ArrayLong>> constructors = Arrays.asList(
            ArrayBub::new,
            ArraySel::new,
            ArrayIns::new,
            ArrayMerge::new,
            ArraySh::new
    );

    public static void main(String[] args) {
        SortingExperiment testRandom = new SortingExperiment("Sorting random data:",
                constructors, MAX_SIZE, E01TimingRandom::fillRandom);
        testRandom.run();
    }

    private static void fillRandom(ArrayLong arr) {
        Random random = new Random();
        while (arr.isNotFull()) {
            arr.insert(random.nextLong());
        }
    }
}
/*
Results 2018-12-04:
ArrayBub   finished in 21638 milliseconds
ArraySel   finished in  5223 milliseconds
ArrayIns   finished in  1151 milliseconds
ArrayMerge finished in    15 milliseconds
ArraySh    finished in    19 milliseconds
 */
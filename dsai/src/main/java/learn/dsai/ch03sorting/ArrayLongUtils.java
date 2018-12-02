package learn.dsai.ch03sorting;

import learn.dsai.tools.Stopwatch;

import java.util.function.Consumer;

public class ArrayLongUtils {
    /**
     * Fills the array wrapper using the specified consumer which takes the job of filling array
     * and then invokes sorting method. Displays elapsed time in milliseconds.
     * @param arr array wrapper object
     * @param filler consumer which fills the array
     * @param label label used in output
     */
    public static void fillAndSort(ArrayLong arr, Consumer<ArrayLong> filler, String label) {
        filler.accept(arr);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        arr.sort();
        stopwatch.stop();
        System.out.printf("%-10s finished in %5d milliseconds%n", label, stopwatch.getElapsed());
    }
}

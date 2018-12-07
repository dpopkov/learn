package learn.dsai.ch07advsort.experiments;

import learn.dsai.ch03sorting.ArrayLong;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;

import static learn.dsai.ch03sorting.ArrayLongUtils.fillAndSort;

/**
 * Sorting experiment for the supplied list of array containers.
 */
public class SortingExperiment implements Runnable {
    /** Title of the experiment. */
    private final String title;
    /** List of constructors used to created tested array containers. */
    private final List<IntFunction<? extends ArrayLong>> constructors;
    /** Number of elements in tested arrays. */
    private final int arraySize;
    /** Consumer that fills arrays with data. */
    private final Consumer<ArrayLong> filler;
    private Thread thread;

    public SortingExperiment(String title,
                             List<IntFunction<? extends ArrayLong>> constructors,
                             int arraySize,
                             Consumer<ArrayLong> filler) {
        this.title = title;
        this.constructors = constructors;
        this.arraySize = arraySize;
        this.filler = filler;
    }

    public void start() {
        thread = new Thread(this, "Thread - " + title);
        thread.start();
    }

    public void join() throws InterruptedException {
        if (thread != null && thread.isAlive()) {
            thread.join();
        } else {
            throw new IllegalStateException("Thread is null or not alive");
        }
    }

    public void run() {
        System.out.println(title);
        for (IntFunction<? extends ArrayLong> c : constructors) {
            ArrayLong arr = c.apply(arraySize);
            fillAndSort(arr, filler, arr.getClass().getSimpleName());
        }
    }
}

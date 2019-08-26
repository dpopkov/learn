package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.PositionalList;
import learn.dsajg6e.ch09priorityqueues.HeapPriorityQueue;
import learn.dsajg6e.tools.Input;
import learn.dsajg6e.tools.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P0950RunningTime {
    public static void main(String[] args) {
        int size = Input.nextInt("Enter size of input: ");
        List<Long> values = prepareRandomValues(size);

        PositionalList<Long> list = new LinkedPositionalList<>();
        for (Long v : values) {
            list.addLast(v);
        }
        StopWatch sw = new StopWatch();
        sw.start();
        HeapPriorityQueue.pqSort(list);
        sw.stop();
        showResult(sw, "Not in place sorting:");

        Long[] inPlaceValues = values.toArray(new Long[0]);
        P0950HeapSortInPlace<Long> sorter = new P0950HeapSortInPlace<>(inPlaceValues);
        sw.start();
        sorter.sort();
        sw.stop();
        showResult(sw, "In place sorting:");
    }

    private static void showResult(StopWatch sw, String title) {
        long time = sw.getElapsed();
        System.out.println(title);
        System.out.println("time = " + time);
    }

    private static List<Long> prepareRandomValues(int size) {
        Random random = new Random();
        List<Long> values = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            values.add(random.nextLong());
        }
        return values;
    }
}

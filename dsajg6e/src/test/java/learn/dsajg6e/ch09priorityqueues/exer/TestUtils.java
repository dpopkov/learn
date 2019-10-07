package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09pq2.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestUtils {
    private TestUtils() {
    }

    public static void fillQueueWithKeys(PriorityQueue<Integer, String> queue, List<Integer> keys) {
        for (Integer n : keys) {
            queue.insert(n, null);
        }
    }

    public static List<Integer> prepareNonRandomShuffledNumbers(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list, new Random(3));
        return list;
    }
}

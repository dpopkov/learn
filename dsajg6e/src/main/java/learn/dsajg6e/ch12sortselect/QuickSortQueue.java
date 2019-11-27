package learn.dsajg6e.ch12sortselect;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;

import java.util.Comparator;

public class QuickSortQueue {
    public static <K> void quickSort(Queue<K> s, Comparator<K> comp) {
        int n = s.size();
        if (n < 2) {
            return;
        }
        K pivot = s.first();
        Queue<K> less = new LinkedQueue<>();
        Queue<K> equal = new LinkedQueue<>();
        Queue<K> greater = new LinkedQueue<>();
        while (!s.isEmpty()) {
            K element = s.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) {
                less.enqueue(element);
            } else if (c == 0) {
                equal.enqueue(element);
            } else {
                greater.enqueue(element);
            }
        }
        quickSort(less, comp);
        quickSort(greater, comp);
        transfer(less, s);
        transfer(equal, s);
        transfer(greater, s);
    }

    private static <K> void transfer(Queue<K> from, Queue<K> to) {
        while (!from.isEmpty()) {
            to.enqueue(from.dequeue());
        }
    }
}

package learn.dsajg6e.ch12sortselect;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;

import java.util.Comparator;

public class MergeSortQueue {
    /** Merge contents of sorted queues s1 and s2 into empty queue s. */
    public static <K> void merge(Queue<K> s1, Queue<K> s2, Queue<K> s, Comparator<K> comp) {
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (comp.compare(s1.first(), s2.first()) < 0) {
                s.enqueue(s1.dequeue());
            } else {
                s.enqueue(s2.dequeue());
            }
        }
        while (!s1.isEmpty()) {
            s.enqueue((s1.dequeue()));
        }
        while (!s2.isEmpty()) {
            s.enqueue((s2.dequeue()));
        }
    }

    /** Merge-sort contents of queue. */
    public static <K> void mergeSort(Queue<K> s, Comparator<K> comp) {
        int n = s.size();
        if (n < 2) {
            return;
        }
        Queue<K> s1 = new LinkedQueue<>();
        Queue<K> s2 = new LinkedQueue<>();
        while (s1.size() < n / 2) {
            s1.enqueue(s.dequeue());
        }
        while (!s.isEmpty()) {
            s2.enqueue(s.dequeue());
        }
        mergeSort(s1, comp);
        mergeSort(s2, comp);
        merge(s1, s2, s, comp);
    }
}

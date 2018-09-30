package learn.ijpds.ch20collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Georgia");
        queue.offer("Texas");
        System.out.println("Priority Queue using Comparable:");
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("\nPriority queue using Comparator:");
        PriorityQueue<String> queue2 = new PriorityQueue<>(4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        while (queue2.size() > 0) {
            System.out.print(queue2.poll() + " ");
        }
    }
}

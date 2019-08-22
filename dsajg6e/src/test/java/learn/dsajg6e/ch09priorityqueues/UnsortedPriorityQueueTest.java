package learn.dsajg6e.ch09priorityqueues;

import org.junit.Test;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;

public class UnsortedPriorityQueueTest {

    @Test
    public void minReturnsMinimalElement() {
        UnsortedPriorityQueue<Integer, String> queue = new UnsortedPriorityQueue<>();
        queue.insert(10, "Ten");
        assertEntry(queue.min(), 10, "Ten");
        queue.insert(5, "Five");
        assertEntry(queue.min(), 5, "Five");
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        UnsortedPriorityQueue<Integer, String> queue = new UnsortedPriorityQueue<>();
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }
}

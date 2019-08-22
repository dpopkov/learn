package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;

public class R0905FastUnsortedPriorityQueueTest {
    @Test
    public void minReturnsMinimalElement() {
        R0905FastUnsortedPriorityQueue<Integer, String> queue = new R0905FastUnsortedPriorityQueue<>();
        queue.insert(10, "Ten");
        assertEntry(queue.min(), 10, "Ten");
        queue.insert(5, "Five");
        assertEntry(queue.min(), 5, "Five");
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        R0905FastUnsortedPriorityQueue<Integer, String> queue = new R0905FastUnsortedPriorityQueue<>();
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }
}

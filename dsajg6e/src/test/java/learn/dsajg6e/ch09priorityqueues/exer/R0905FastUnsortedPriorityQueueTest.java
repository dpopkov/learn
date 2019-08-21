package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.Entry;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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

    private static void assertEntry(Entry<Integer, String> entry, int key, String value) {
        assertThat(entry.getKey(), is(key));
        assertThat(entry.getValue(), is(value));
    }
}

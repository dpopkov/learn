package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class C0928SortedArrayPriorityQueueTest {

    @Test
    public void minReturnsMinimalElement() {
        C0928SortedArrayPriorityQueue<Integer, String> queue = new C0928SortedArrayPriorityQueue<>(3);
        queue.insert(5, "Five");
        assertEntry(queue.min(), 5, "Five");
        queue.insert(10, "Ten");
        assertEntry(queue.min(), 5, "Five");
        assertThat(queue.size(), is(2));
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        C0928SortedArrayPriorityQueue<Integer, String> queue = new C0928SortedArrayPriorityQueue<>(3);
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }
}

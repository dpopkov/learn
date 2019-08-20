package learn.dsajg6e.ch09priorityqueues;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HeapAdaptablePriorityQueueTest {
    @Test
    public void minReturnsMinimalElement() {
        AdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        queue.insert(10, "Ten");
        assertEntry(queue.min(), 10, "Ten");
        queue.insert(5, "Five");
        assertEntry(queue.min(), 5, "Five");
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        AdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }

    @Test
    public void canRemoveEntries() {
        AdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        var e20 = queue.insert(20, "Twenty");
        var e30 = queue.insert(30, "Thirty");
        queue.insert(35, "ThirtyFive");
        queue.insert(40, "Forty");
        queue.insert(10, "Ten");
        queue.remove(e30);
        assertThat(queue.size(), is(4));
        queue.remove(e20);
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 35, "ThirtyFive");
        assertEntry(queue.removeMin(), 40, "Forty");
    }

    @Test
    public void canReplaceKey() {
        AdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        queue.insert(20, "Twenty");
        var e30 = queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        queue.replaceKey(e30, 5);
        assertEntry(queue.removeMin(), 5, "Thirty");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
    }

    @Test
    public void canReplaceValue() {
        AdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        queue.insert(20, "Twenty");
        var e30 = queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        queue.replaceValue(e30, "THIRTY");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "THIRTY");
    }

    private static void assertEntry(Entry<Integer, String> entry, int key, String value) {
        assertThat(entry.getKey(), is(key));
        assertThat(entry.getValue(), is(value));
    }
}

package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;

public class C0931HeapLinkedTreePQueueTest {

    @Test
    public void whenAddEntriesThenMinReturnsMinimalElement() {
        C0931HeapLinkedTreePQueue<Integer, String> queue = new C0931HeapLinkedTreePQueue<>();
        assertMin(queue, 10, "Ten", 10, "Ten");
        assertMin(queue, 5, "Five", 5, "Five");
        assertMin(queue, 4, "Four", 4, "Four");
        assertMin(queue, 3, "Three", 3, "Three");
        assertMin(queue, 2, "Two", 2, "Two");
        assertMin(queue, 1, "One", 1, "One");
    }

    private <K, V> void assertMin(C0931HeapLinkedTreePQueue<K, V> queue, K key, V value, K expectedKey, V expectedValue) {
        queue.insert(key, value);
        assertEntry(queue.min(), expectedKey, expectedValue);
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        C0931HeapLinkedTreePQueue<Integer, String> queue = new C0931HeapLinkedTreePQueue<>();
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        queue.insert(5, "Five");
        queue.insert(4, "Four");
        queue.insert(3, "Three");
        queue.insert(2, "Two");
        assertEntry(queue.removeMin(), 2, "Two");
        assertEntry(queue.removeMin(), 3, "Three");
        assertEntry(queue.removeMin(), 4, "Four");
        assertEntry(queue.removeMin(), 5, "Five");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }
}

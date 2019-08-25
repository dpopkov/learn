package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;

public class C0933HeapLinkedTreePQueueBinTest {
    @Test
    public void whenAddEntriesThenMinReturnsMinimalElement() {
        C0933HeapLinkedTreePQueueBin<Integer, String> queue = new C0933HeapLinkedTreePQueueBin<>();
        assertMin(queue, 20, "Twenty");
        assertMin(queue, 10, "Ten");
        assertMin(queue, 5, "Five");
        assertMin(queue, 4, "Four");
        assertMin(queue, 3, "Three");
        assertMin(queue, 2, "Two");
        assertMin(queue, 1, "One");
    }

    private <K, V> void assertMin(C0933HeapLinkedTreePQueueBin<K, V> queue, K key, V value) {
        queue.insert(key, value);
        assertEntry(queue.min(), key, value);
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        C0933HeapLinkedTreePQueueBin<Integer, String> queue = new C0933HeapLinkedTreePQueueBin<>();
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

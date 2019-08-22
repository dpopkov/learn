package learn.dsajg6e.ch09priorityqueues;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import org.junit.Test;

import java.util.Iterator;

import static learn.dsajg6e.ch09priorityqueues.EntryAssertions.assertEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HeapPriorityQueueTest {

    @Test
    public void minReturnsMinimalElement() {
        HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<>();
        queue.insert(10, "Ten");
        assertEntry(queue.min(), 10, "Ten");
        queue.insert(5, "Five");
        assertEntry(queue.min(), 5, "Five");
    }

    @Test
    public void removeMinDeletesMinimalElement() {
        HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<>();
        queue.insert(20, "Twenty");
        queue.insert(30, "Thirty");
        queue.insert(10, "Ten");
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }

    @Test
    public void whenConstructWithKeysAndValuesThenHeapIsInitialized() {
        Integer[] keys = {20, 30, 10};
        String[] values = {"Twenty", "Thirty", "Ten"};
        HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<>(keys, values);
        assertEntry(queue.removeMin(), 10, "Ten");
        assertEntry(queue.removeMin(), 20, "Twenty");
        assertEntry(queue.removeMin(), 30, "Thirty");
    }

    @Test
    public void canSortElements() {
        Integer[] keys = {20, 30, 10, 40, 50};
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        for (Integer i : keys) {
            list.addLast(i);
        }
        HeapPriorityQueue.pqSort(list);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(30));
        assertThat(it.next(), is(40));
        assertThat(it.next(), is(50));
        assertThat(it.hasNext(), is(false));
    }
}

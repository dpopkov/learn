package learn.dsajg6e.ch09pq2;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HeapPriorityQueueTest {

    @Test
    public void testConstructionFromArrays() {
        Integer[] numbers = {3, 1, 2};
        String[] names = {"Three", "One", "Two"};
        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>(numbers, names);
        Entry<Integer, String> e = heap.removeMin();
        assertThat(e.getKey(), is(1));
        assertThat(e.getValue(), is("One"));
        e = heap.removeMin();
        assertThat(e.getKey(), is(2));
        assertThat(e.getValue(), is("Two"));
        e = heap.removeMin();
        assertThat(e.getKey(), is(3));
        assertThat(e.getValue(), is("Three"));
    }
}

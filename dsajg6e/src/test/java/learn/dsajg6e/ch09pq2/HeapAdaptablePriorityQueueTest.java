package learn.dsajg6e.ch09pq2;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HeapAdaptablePriorityQueueTest {

    @Test
    public void testRemove() {
        HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        Entry<Integer, String> e = queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.min().getKey(), is(10));
        queue.remove(e);
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(30));
    }

    @Test
    public void replaceKey() {
        HeapAdaptablePriorityQueue<Integer, String> queue = new HeapAdaptablePriorityQueue<>();
        Entry<Integer, String> e = queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.min().getKey(), is(10));
        queue.replaceKey(e, 2);
        assertThat(queue.removeMin().getKey(), is(2));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(30));
    }
}

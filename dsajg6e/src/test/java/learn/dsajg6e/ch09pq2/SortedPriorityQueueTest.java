package learn.dsajg6e.ch09pq2;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SortedPriorityQueueTest {

    @Test
    public void testInsert() {
        SortedPriorityQueue<Integer, String> queue = new SortedPriorityQueue<>();
        queue.insert(3, "Three");
        assertThat(queue.min().getKey(), is(3));
        queue.insert(1, "One");
        assertThat(queue.min().getKey(), is(1));
        queue.insert(2, "Two");
        assertThat(queue.min().getKey(), is(1));
        assertThat(queue.removeMin().getKey(), is(1));
        assertThat(queue.removeMin().getKey(), is(2));
        assertThat(queue.removeMin().getKey(), is(3));
    }
}

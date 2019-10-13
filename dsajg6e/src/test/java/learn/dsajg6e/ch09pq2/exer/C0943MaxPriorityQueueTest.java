package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0943MaxPriorityQueueTest {

    @Test
    public void testInsertRemoveMax() {
        var queue = new C0943MaxPriorityQueue<Integer>();
        queue.insert(20);
        queue.insert(30);
        queue.insert(10);
        assertMax(queue, 30);
        assertMax(queue, 20);
        queue.insert(15);
        queue.insert(5);
        assertMax(queue, 15);
        assertMax(queue, 10);
        assertMax(queue, 5);
        assertThat(queue.isEmpty(), is(true));
    }

    private void assertMax(C0943MaxPriorityQueue<Integer> queue, int key) {
        assertThat(queue.isEmpty(), is(false));
        assertThat(queue.max(), is(key));
        assertThat(queue.removeMax(), is(key));
    }
}

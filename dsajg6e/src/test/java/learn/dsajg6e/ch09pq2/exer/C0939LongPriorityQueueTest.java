package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0939LongPriorityQueueTest {

    @Test
    public void testInsertRemove() {
        final int maximum = 5;
        LongPriorityQueue queue = new C0939LongPriorityQueue(maximum);
        queue.insert(3);
        queue.insert(2);
        queue.insert(4);
        queue.insert(1);
        queue.insert(5);
        for (int expected = 1; expected <= maximum; expected++) {
            assertThat(queue.size(), is(maximum - expected + 1));
            assertEquals(expected, queue.min());
            assertEquals(expected, queue.removeMin());
        }
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveMaximum() {
        LongPriorityQueue queue = new C0939LongPriorityQueue(
                C0939LongPriorityQueue.MAXIMUM_ORIENTED, 5);
        queue.insert(3);
        queue.insert(2);
        queue.insert(4);
        queue.insert(1);
        queue.insert(5);
        for (int expected = 5; expected >= 1; expected--) {
            assertEquals(expected, queue.min());
            assertEquals(expected, queue.removeMin());
        }
        assertThat(queue.isEmpty(), is(true));
    }
}

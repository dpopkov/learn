package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedCircularQueueTest {
    @Test
    public void whenEnqueueAndDequeThenImplementsFIFO() {
        Queue<Integer> queue = new LinkedCircularQueue<>();
        queue.enqueue(10);
        assertThat(queue.first(), is(10));
        queue.enqueue(20);
        assertThat(queue.size(), is(2));
        assertThat(queue.dequeue(), is(10));
        queue.enqueue(30);
        assertThat(queue.first(), is(20));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.first(), is(30));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void whenRotateThenFirstElementGoesBack() {
        CircularQueue<Integer> queue = new LinkedCircularQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.rotate();
        assertThat(queue.first(), is(20));
        queue.rotate();
        assertThat(queue.first(), is(10));
        queue.rotate();
        assertThat(queue.first(), is(20));
    }
}

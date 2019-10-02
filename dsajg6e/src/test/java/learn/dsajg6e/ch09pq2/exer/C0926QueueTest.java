package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0926QueueTest {

    @Test
    public void testEnqueueDequeue() {
        var queue = new C0926Queue<Integer>();
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(20);
        assertThat(queue.dequeue(), is(10));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }
}

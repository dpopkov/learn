package learn.dsajg6e.ch09priorityqueues.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0926QueueOnPQTest {

    @Test
    public void implementsFifo() {
        C0926QueueOnPQ<Integer> queue = new C0926QueueOnPQ<>();
        queue.enqueue(10);
        queue.enqueue(20);
        assertThat(queue.size(), is(2));
        assertThat(queue.dequeue(), is(10));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }
}

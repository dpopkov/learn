package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedQueueTest {
    @Test
    public void whenEnqueueAndDequeThenImplementsFIFO() {
        Queue<Integer> queue = new LinkedQueue<>();
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
    public void whenConcatenateThenContainsElementsFromOtherQueueThatBecomesEmpty() {
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        LinkedQueue<Integer> queue2 = new LinkedQueue<>();
        queue2.enqueue(30);
        queue2.enqueue(40);
        queue1.concatenate(queue2);
        assertThat(queue1.dequeue(), is(10));
        assertThat(queue1.dequeue(), is(20));
        assertThat(queue1.dequeue(), is(30));
        assertThat(queue1.dequeue(), is(40));
        assertThat(queue2.isEmpty(), is(true));
    }
}

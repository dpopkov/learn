package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void whenEnqueueAndDequeThenImplementsFIFO() {
        Queue<Integer> queue = new ArrayQueue<>(2);
        queue.enqueue(10);
        assertThat(queue.first(), is(10));
        queue.enqueue(20);                          // 10 20
        assertThat(queue.size(), is(2));
        assertThat(queue.dequeue(), is(10));    // 20
        queue.enqueue(30);                          // 20 30
        assertThat(queue.first(), is(20));
        assertThat(queue.dequeue(), is(20));    // 30
        assertThat(queue.first(), is(30));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenEnqueueBeyondLimitThenException() {
        Queue<Integer> queue = new ArrayQueue<>(1);
        queue.enqueue(10);
        queue.enqueue(20);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenCloneThenNewQueueIsNotLinkedWithOld() {
        ArrayQueue<Integer> queue1 = new ArrayQueue<>(2);
        queue1.enqueue(10);
        queue1.enqueue(20);
        ArrayQueue<Integer> queue2 = (ArrayQueue<Integer>) queue1.clone();
        queue1.dequeue();
        Integer rst = queue2.dequeue();
        assertThat(rst, is(10));
    }
}

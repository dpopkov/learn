package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Queue;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0735DynamicArrayQueueTest {
    @Test
    public void canImplementSimpleFIFO() {
        Queue<Integer> queue = new C0735DynamicArrayQueue<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertThat(queue.dequeue(), is(10));
        assertThat(queue.first(), is(20));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }


    @Test
    public void whenEnqueueDequeueMoreThanCapacityThenStillImplementsFIFO() {
        Queue<Integer> queue = new C0735DynamicArrayQueue<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertThat(queue.dequeue(), is(10));
        queue.enqueue(30);
        assertThat(queue.dequeue(), is(20));
        queue.enqueue(40);
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.dequeue(), is(40));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void whenEnqueueMoreThanCapacityThenResize() {
        Queue<Integer> queue = new C0735DynamicArrayQueue<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertThat(queue.dequeue(), is(10));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void whenEnqueueDequeMoreThanCapacityThenResize() {
        Queue<Integer> queue = new C0735DynamicArrayQueue<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertThat(queue.dequeue(), is(10));
        queue.enqueue(30);
        assertThat(queue.size(), is(2));
        queue.enqueue(40);
        assertThat(queue.size(), is(3));
        assertThat(queue.dequeue(), is(20));
        assertThat(queue.dequeue(), is(30));
        assertThat(queue.dequeue(), is(40));
        assertThat(queue.isEmpty(), is(true));
    }
}

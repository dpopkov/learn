package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.CircularQueue;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0615ArrayQueueRotatedTest {
    @Test
    public void whenRotateThenFirstElementGoesBack() {
        CircularQueue<Integer> queue = new R0615ArrayQueueRotated<>(2);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.rotate();
        assertThat(queue.first(), is(20));
        queue.rotate();
        assertThat(queue.first(), is(10));
    }
}

package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Deque;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R0703DequeTest {

    @Test
    public void implementsQueueBackToFront() {
        Deque<Integer> deque = new R0703Deque<>();
        deque.addLast(10);
        deque.addLast(20);
        assertThat(deque.last(), is(20));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeFirst(), is(10));
        assertThat(deque.removeFirst(), is(20));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void implementsQueueFrontToBack() {
        Deque<Integer> deque = new R0703Deque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        assertThat(deque.first(), is(20));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeLast(), is(10));
        assertThat(deque.removeLast(), is(20));
        assertThat(deque.isEmpty(), is(true));
    }
}

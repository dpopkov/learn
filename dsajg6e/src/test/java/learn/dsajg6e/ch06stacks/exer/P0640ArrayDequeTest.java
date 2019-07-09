package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0640ArrayDequeTest {
    @Test
    public void implementsFifoLastToFirst() {
        Deque<Integer> deque = new P0640ArrayDeque<>(2);
        deque.addLast(10);
        deque.addLast(20);
        assertThat(deque.first(), is(10));
        assertThat(deque.last(), is(20));
        assertThat(deque.removeFirst(), is(10));
        assertThat(deque.first(), is(20));
        deque.addLast(30);
        assertThat(deque.last(), is(30));
        assertThat(deque.removeFirst(), is(20));
        assertThat(deque.removeFirst(), is(30));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void implementsFifoFirstToLast() {
        Deque<Integer> deque = new P0640ArrayDeque<>(2);
        deque.addFirst(10);
        deque.addFirst(20);
        assertThat(deque.removeLast(), is(10));
        deque.addFirst(30);
        assertThat(deque.removeLast(), is(20));
        assertThat(deque.removeLast(), is(30));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void implementsFifoInBothDirections() {
        Deque<Integer> deque = new P0640ArrayDeque<>(3);
        deque.addLast(20);
        deque.addFirst(10);
        deque.addLast(30);
        assertThat(deque.removeFirst(), is(10));
        assertThat(deque.removeLast(), is(30));
        assertThat(deque.removeLast(), is(20));
    }
}

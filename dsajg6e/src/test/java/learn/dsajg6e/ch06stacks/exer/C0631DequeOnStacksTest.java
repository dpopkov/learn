package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0631DequeOnStacksTest {

    @Test
    public void testAddLastRemoveFirst() {
        Deque<Integer> deque = new C0631DequeOnStacks<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        assertThat(deque.removeFirst(), is(10));
        assertThat(deque.removeFirst(), is(20));
        assertThat(deque.removeFirst(), is(30));
    }

    @Test
    public void testAddFirstRemoveLast() {
        Deque<Integer> deque = new C0631DequeOnStacks<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        assertThat(deque.removeLast(), is(10));
        assertThat(deque.removeLast(), is(20));
        assertThat(deque.removeLast(), is(30));
    }

    @Test
    public void whenRandomAdditionsThenOperatesCorrect() {
        Deque<Integer> deque = new C0631DequeOnStacks<>();
        deque.addFirst(10);
        deque.addLast(20);
        assertThat(deque.last(), is(20));
        assertThat(deque.first(), is(10));
        deque.addFirst(5);
        deque.addLast(25);
        assertThat(deque.first(), is(5));
        assertThat(deque.last(), is(25));
        assertThat(deque.removeFirst(), is(5));
        assertThat(deque.removeLast(), is(25));
    }

    @Test
    public void whenAddLastAddFirstThenInOrder() {
        Deque<Integer> deque = new C0631DequeOnStacks<>();
        deque.addLast(20);
        deque.addFirst(10);
        assertThat(deque.removeFirst(), is(10));
        assertThat(deque.removeFirst(), is(20));
    }
}

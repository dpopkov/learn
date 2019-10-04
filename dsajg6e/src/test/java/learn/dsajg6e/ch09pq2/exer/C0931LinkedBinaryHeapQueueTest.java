package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0931LinkedBinaryHeapQueueTest {

    @Test
    public void testInsertRemoveOne() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(10, "ten");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveTwo() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(10, "ten");
        queue.insert(20, "two");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveTwoReversed() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(20, "two");
        queue.insert(10, "ten");
        assertThat(queue.min().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testInsertRemoveThree() {
        var queue = new C0931LinkedBinaryHeapQueue<Integer, String>();
        queue.insert(20, "twenty");
        queue.insert(10, "ten");
        queue.insert(30, "thirty");
        assertThat(queue.removeMin().getKey(), is(10));
        assertThat(queue.removeMin().getKey(), is(20));
        assertThat(queue.removeMin().getKey(), is(30));
        assertThat(queue.isEmpty(), is(true));
    }

    // todo: add test cases according to fig 9.1
}

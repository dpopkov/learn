package learn.dsai.ch05.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0501PriorityQueueTest {
    private final P0501PriorityQueue queue = new P0501PriorityQueue();

    @Test
    public void testAdd() {
        queue.add(33);
        assertThat(queue.toString(), is("{33}"));
        queue.add(11);
        assertThat(queue.toString(), is("{11} {33}"));
        queue.add(22);
        assertThat(queue.toString(), is("{11} {22} {33}"));
    }

    @Test
    public void remove() {
        queue.add(33);
        queue.add(11);
        queue.add(22);
        assertThat(queue.remove(), is(11L));
        assertThat(queue.remove(), is(22L));
        assertThat(queue.remove(), is(33L));
    }
}

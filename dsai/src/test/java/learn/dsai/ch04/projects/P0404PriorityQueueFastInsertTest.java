package learn.dsai.ch04.projects;

import learn.dsai.ch04.queues.Queue;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0404PriorityQueueFastInsertTest {
    @Test
    public void testIsFull() {
        Queue q = new P0404PriorityQueueFastInsert(2);
        assertThat(q.isFull(), is(false));
        q.insert(11);
        assertThat(q.isFull(), is(false));
        q.insert(11);
        assertThat(q.isFull(), is(true));
    }

    @Test
    public void testIsEmpty() {
        Queue q = new P0404PriorityQueueFastInsert(2);
        assertThat(q.isEmpty(), is(true));
        q.insert(11);
        assertThat(q.isEmpty(), is(false));
    }

    @Test
    public void testInsertd() {
        Queue q = new P0404PriorityQueueFastInsert(2);
        q.insert(22);
        q.insert(11);
        assertThat(q.toString(), is("[22, 11]"));
    }

    @Test
    public void testRemove() {
        Queue q = new P0404PriorityQueueFastInsert(3);
        q.insert(11);
        q.insert(22);
        q.insert(33);
        assertThat(q.size(), is(3));
        assertThat(q.remove(), is(11L));
        assertThat(q.toString(), is("[22, 33]"));
        assertThat(q.remove(), is(22L));
        assertThat(q.toString(), is("[33]"));
        assertThat(q.remove(), is(33L));
        assertThat(q.toString(), is("[]"));
        assertThat(q.size(), is(0));
    }

    @Test
    public void testPeekFront() {
        Queue q = new P0404PriorityQueueFastInsert(3);
        q.insert(11);
        q.insert(22);
        assertThat(q.peekFront(), is(11L));
        q.remove();
        assertThat(q.peekFront(), is(22L));
    }
}

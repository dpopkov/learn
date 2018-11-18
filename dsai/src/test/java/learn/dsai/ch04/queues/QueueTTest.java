package learn.dsai.ch04.queues;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueueTTest {
    @Test
    public void whenRemoveWrappingThenReturnsValues() {
        Queue q = new QueueT(2);
        q.insert(11);                               // 11 -
        q.insert(22);                               // 11 22
        assertThat(q.remove(), is(11L));            // -  22
        q.insert(33);                               // 33 22
        assertThat(q.toString(), is("[22, 33]"));
        assertThat(q.remove(), is(22L));            // 33 -
        assertThat(q.toString(), is("[33]"));
        q.insert(44);                               // 33 44
        assertThat(q.toString(), is("[33, 44]"));
        assertThat(q.remove(), is(33L));            // -  44
        assertThat(q.toString(), is("[44]"));
        assertThat(q.remove(), is(44L));            // -  -
        assertThat(q.isEmpty(), is(true));
    }

    @Test
    public void whenRemoveThenPeeksFrontValue() {
        Queue q = new QueueT(2);
        q.insert(11);
        assertThat(q.peekFront(), is(11L));
        q.insert(22);
        assertThat(q.peekFront(), is(11L));
        assertThat(q.isFull(), is(true));
        assertThat(q.remove(), is(11L));
        assertThat(q.peekFront(), is(22L));
    }
}

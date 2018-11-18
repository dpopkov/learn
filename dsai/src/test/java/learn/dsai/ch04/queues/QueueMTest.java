package learn.dsai.ch04.queues;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class QueueMTest {
    private Queue q;

    @Before
    public void setUp() {
        q = new QueueM(2);
    }

    @Test
    public void whenInsertThenContainsValues() {
        q.insert(11);
        q.insert(22);
        assertThat(q.toString(), is("[11, 22]"));
    }

    @Test
    public void whenRemoveThenReturnsValue() {
        q.insert(11);
        q.insert(22);
        assertThat(q.remove(), is(11L));
        assertThat(q.toString(), is("[22]"));
    }

    @Test
    public void whenFullThenIsFullReturnsTrue() {
        assertThat(q.isFull(), is(false));
        q.insert(11);
        assertThat(q.isFull(), is(false));
        q.insert(11);
        assertThat(q.isFull(), is(true));
    }

    @Test
    public void whenRemoveThenIsFullReturnsFalse() {
        q.insert(11);
        q.insert(22);
        assertThat(q.isFull(), is(true));
        q.remove();
        assertThat(q.isFull(), is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void whenInsertToFullThenThrowsException() {
        q.insert(11);
        q.insert(11);
        q.insert(11);
    }

    @Test
    public void whenInsertWrappingThenContainsValues() {
        q.insert(11);
        q.insert(22);
        q.remove();
        q.insert(33);
        assertThat(q.toString(), is("[22, 33]"));
    }

    @Test
    public void whenRemoveWrappingThenReturnsValues() {
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
        q.insert(11);
        assertThat(q.peekFront(), is(11L));
        q.insert(22);
        assertThat(q.peekFront(), is(11L));
        assertThat(q.remove(), is(11L));
        assertThat(q.peekFront(), is(22L));
    }
}

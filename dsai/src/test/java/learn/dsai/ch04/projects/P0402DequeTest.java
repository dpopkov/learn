package learn.dsai.ch04.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0402DequeTest {

    @Test
    public void testInsert() {
        P0402Deque d = new P0402Deque();
        d.insert(11);
        d.insert(22);
        assertThat(d.toString(), is("[11, 22]"));
    }

    @Test
    public void remove() {
        P0402Deque d = new P0402Deque();
        d.insert(11);
        d.insert(22);
        assertThat(d.remove(), is(11L));
        assertThat(d.remove(), is(22L));
    }

    @Test
    public void testInsertWrapping() {
        P0402Deque d = new P0402Deque(2);
        d.insert(11);
        d.insert(22);
        d.remove();
        d.insert(33);
        assertThat(d.toString(), is("[22, 33]"));
    }

    @Test
    public void removeWrapping() {
        P0402Deque d = new P0402Deque(2);
        d.insert(11);
        d.insert(22);
        assertThat(d.remove(), is(11L));
        d.insert(33);
        assertThat(d.remove(), is(22L));
        assertThat(d.remove(), is(33L));
    }

    @Test
    public void insertLeft() {
        P0402Deque d = new P0402Deque(2);
        d.insertLeft(22);
        d.insertLeft(11);
        assertThat(d.toString(), is("[11, 22]"));
        d.remove();
        d.insertLeft(33);
        assertThat(d.toString(), is("[33, 22]"));
    }

    @Test
    public void insertRight() {
        P0402Deque d = new P0402Deque(2);
        d.insertRight(11);
        d.insertRight(22);
        assertThat(d.toString(), is("[11, 22]"));
    }

    @Test
    public void removeLeft() {
        P0402Deque d = new P0402Deque(2);
        d.insertRight(11);
        d.insertRight(22);
        assertThat(d.removeLeft(), is(11L));
        assertThat(d.removeLeft(), is(22L));
    }

    @Test
    public void removeRight() {
        P0402Deque d = new P0402Deque(2);
        d.insert(22);
        d.insert(11);
        assertThat(d.removeRight(), is(11L));
        d.insert(33);
        assertThat(d.removeRight(), is(33L));
    }
}

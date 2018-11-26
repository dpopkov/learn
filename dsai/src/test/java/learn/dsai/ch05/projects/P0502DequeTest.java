package learn.dsai.ch05.projects;

import learn.dsai.ch04.projects.Deque;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0502DequeTest {
    private final Deque deque = new P0502Deque();

    @Test
    public void insertLeft() {
        deque.insertLeft(11);
        deque.insertLeft(22);
        assertThat(deque.toString(), is("[22 11]"));
        deque.insertLeft(33);
        assertThat(deque.toString(), is("[33 22 11]"));
    }

    @Test
    public void insertRight() {
        deque.insertRight(11);
        deque.insertRight(22);
        assertThat(deque.toString(), is("[11 22]"));
    }

    @Test
    public void removeLeft() {
        deque.insertRight(11);
        deque.insertRight(22);
        assertThat(deque.removeLeft(), is(11L));
        assertThat(deque.removeLeft(), is(22L));
    }

    @Test
    public void removeRight() {
        deque.insertLeft(11);
        deque.insertLeft(22);
        assertThat(deque.removeRight(), is(11L));
        deque.insertLeft(33);
        assertThat(deque.removeRight(), is(22L));
        assertThat(deque.removeRight(), is(33L));
    }
}

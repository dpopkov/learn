package learn.dsajg6e.ch03fund.linked;

import org.junit.Test;

import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private final Supplier<IDoublyList<Integer>> constructor = DoublyLinkedList::new;

    @Test
    public void testAddFirst() {
        IList<Integer> list = constructor.get();
        list.addFirst(1);
        assertThat(list.first(), is(1));
        assertThat(list.last(), is(1));
        assertThat(list.toString(), is("[1]"));
        list.addFirst(2);
        assertThat(list.first(), is(2));
        assertThat(list.last(), is(1));
        assertThat(list.toString(), is("[2, 1]"));
    }

    @Test
    public void testAddLast() {
        IList<Integer> list = constructor.get();
        list.addLast(1);
        assertThat(list.first(), is(1));
        assertThat(list.last(), is(1));
        assertThat(list.toString(), is("[1]"));
        list.addLast(2);
        assertThat(list.first(), is(1));
        assertThat(list.last(), is(2));
        assertThat(list.toString(), is("[1, 2]"));
    }

    @Test
    public void testRemoveFirst() {
        IList<Integer> list = constructor.get();
        list.addLast(2);
        list.addLast(1);
        Integer i = list.removeFirst();
        assertThat(i, is(2));
        assertThat(list.first(), is(1));
        assertThat(list.last(), is(1));
        assertThat(list.toString(), is("[1]"));
        i = list.removeFirst();
        assertThat(i, is(1));
        assertTrue(list.isEmpty());
        assertThat(list.toString(), is("[]"));
    }

    @Test
    public void testRemoveLast() {
        IDoublyList<Integer> list = constructor.get();
        list.addLast(2);
        list.addLast(1);
        Integer i = list.removeLast();
        assertThat(i, is(1));
        assertThat(list.first(), is(2));
        assertThat(list.last(), is(2));
        assertThat(list.toString(), is("[2]"));
        assertThat(list.size(), is(1));
        i = list.removeLast();
        assertThat(i, is(2));
        assertTrue(list.isEmpty());
        assertThat(list.toString(), is("[]"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testClone() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        DoublyLinkedList<Integer> list2 = (DoublyLinkedList<Integer>) list1.clone();
        assertThat(list1.first(), is(list2.first()));
        assertThat(list1.last(), is(list2.last()));
        list1.addFirst(-1);
        assertThat(list1.first(), is(not(list2.first())));
        list2.addLast(4);
        assertThat(list1.last(), is(not(list2.last())));
    }
}

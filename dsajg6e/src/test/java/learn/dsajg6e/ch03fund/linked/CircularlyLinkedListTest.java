package learn.dsajg6e.ch03fund.linked;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CircularlyLinkedListTest {

    @Test
    public void testAddFirst() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
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
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(1);
        assertThat(list.toString(), is("[1]"));
        assertThat(list.last(), is(1));
        assertThat(list.first(), is(1));
        list.addLast(2);
        assertThat(list.toString(), is("[1, 2]"));
        assertThat(list.last(), is(2));
        assertThat(list.first(), is(1));
    }

    @Test
    public void testRemoveFirst() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(2);
        list.addLast(1);
        assertThat(list.size(), is(2));
        Integer e = list.removeFirst();
        assertThat(e, is(2));
        assertThat(list.toString(), is("[1]"));
        assertThat(list.last(), is(1));
        assertThat(list.first(), is(1));
        assertThat(list.size(), is(1));
        e = list.removeFirst();
        assertThat(e, is(1));
        assertThat(list.toString(), is("[]"));
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRotate() {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThat(list.toString(), is("[1, 2, 3]"));
        list.rotate();
        assertThat(list.last(), is(1));
        assertThat(list.first(), is(2));
        assertThat(list.toString(), is("[2, 3, 1]"));
    }

    @Test
    public void testEquals() {
        CircularlyLinkedList<Integer> list1 = new CircularlyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        CircularlyLinkedList<Integer> list2 = new CircularlyLinkedList<>();
        assertThat(list1.equals(list2), is(false));
        list2.addLast(1);
        list2.addLast(2);
        assertThat(list1.equals(list2), is(true));
        list2.rotate();
        assertThat(list1.equals(list2), is(false));
        list1.rotate();
        assertThat(list1.equals(list2), is(true));
    }
}

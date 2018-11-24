package learn.dsai.ch05.doubly;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private final DoublyLinkedList list = new DoublyLinkedList();

    @Test
    public void testIsEmpty() {
        assertThat(list.isEmpty(), is(true));
        list.insertFirst(11);
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testInsertFirst() {
        list.insertFirst(11);
        assertThat(list.toString(), is("[11]"));
        list.insertFirst(22);
        assertThat(list.toString(), is("[22 11]"));
        assertThat(list.toString(false), is("[11 22]"));
    }

    @Test
    public void testInsertLast() {
        list.insertLast(11);
        assertThat(list.toString(), is("[11]"));
        list.insertLast(22);
        assertThat(list.toString(), is("[11 22]"));
        assertThat(list.toString(false), is("[22 11]"));
    }

    @Test
    public void testDeleteFirst() {
        list.insertFirst(33);
        list.insertFirst(22);
        list.insertFirst(11);
        assertThat(list.deleteFirst(), is(11L));
        assertThat(list.toString(), is("[22 33]"));
        assertThat(list.toString(false), is("[33 22]"));
        assertThat(list.deleteFirst(), is(22L));
        assertThat(list.toString(), is("[33]"));
        assertThat(list.toString(false), is("[33]"));
        assertThat(list.deleteFirst(), is(33L));
        assertThat(list.toString(), is("[]"));
        assertThat(list.toString(false), is("[]"));
    }

    @Test
    public void testDeleteLast() {
        list.insertLast(33);
        list.insertLast(22);
        list.insertLast(11);
        assertThat(list.deleteLast(), is(11L));
        assertThat(list.toString(), is("[33 22]"));
        assertThat(list.toString(false), is("[22 33]"));
        assertThat(list.deleteLast(), is(22L));
        assertThat(list.toString(), is("[33]"));
        assertThat(list.toString(false), is("[33]"));
        assertThat(list.deleteLast(), is(33L));
        assertThat(list.toString(), is("[]"));
        assertThat(list.toString(false), is("[]"));
    }

    @Test
    public void testInsertAfter() {
        list.insertFirst(11);
        assertThat(list.insertAfter(11, 33), is(true));
        assertThat(list.toString(), is("[11 33]"));
        assertThat(list.toString(false), is("[33 11]"));
        assertThat(list.insertAfter(11, 22), is(true));
        assertThat(list.toString(), is("[11 22 33]"));
        assertThat(list.toString(false), is("[33 22 11]"));
        assertThat(list.insertAfter(44, 55), is(false));
    }

    @Test
    public void testDeleteKey() {
        list.insertLast(11);
        list.insertLast(22);
        list.insertLast(33);
        assertNull(list.deleteKey(44));
        assertThat(list.toString(), is("[11 22 33]"));
        assertThat(list.toString(false), is("[33 22 11]"));
        assertThat(list.deleteKey(22).data, is(22L));
        assertThat(list.toString(), is("[11 33]"));
        assertThat(list.toString(false), is("[33 11]"));
        assertThat(list.deleteKey(11).data, is(11L));
        assertThat(list.toString(), is("[33]"));
        assertThat(list.toString(false), is("[33]"));
        assertThat(list.deleteKey(33).data, is(33L));
        assertThat(list.toString(), is("[]"));
        assertThat(list.toString(false), is("[]"));
    }
}

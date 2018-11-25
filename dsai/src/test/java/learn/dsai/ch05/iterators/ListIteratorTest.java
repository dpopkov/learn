package learn.dsai.ch05.iterators;

import learn.dsai.ch05.doubly.DoublyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ListIteratorTest {
    private DoublyLinkedList list = new DoublyLinkedList();
    private ListIterator it;

    @Before
    public void setUp() {
        list.insertLast(11);
        list.insertLast(22);
        list.insertLast(33);
        it = list.getIterator();
    }

    @Test
    public void testReset() {
        assertThat(it.getCurrent().data, is(11L));
        it.nextLink();
        assertThat(it.getCurrent().data, is(22L));
        it.reset();
        assertThat(it.getCurrent().data, is(11L));
    }

    @Test
    public void testAtEnd() {
        assertThat(it.atEnd(), is(false));
        it.nextLink();
        it.nextLink();
        assertThat(it.atEnd(), is(true));
    }

    @Test
    public void testNextLink() {
        assertThat(it.getCurrent().data, is(11L));
        it.nextLink();
        assertThat(it.getCurrent().data, is(22L));
        it.nextLink();
        assertThat(it.getCurrent().data, is(33L));
    }

    @Test
    public void testInsertAfter() {
        it.insertAfter(12);
        assertThat(list.toString(), is("[11 12 22 33]"));
        assertThat(list.toString(false), is("[33 22 12 11]"));
        assertThat(it.getCurrent().data, is(12L));
        it.nextLink();
        assertThat(it.getCurrent().data, is(22L));
        it.nextLink();
        assertThat(it.getCurrent().data, is(33L));
        it.insertAfter(44);
        assertThat(list.toString(), is("[11 12 22 33 44]"));
        assertThat(list.toString(false), is("[44 33 22 12 11]"));
        assertThat(it.getCurrent().data, is(44L));
    }

    @Test
    public void testInsertBefore() {
        it.insertBefore(10);
        assertThat(list.toString(), is("[10 11 22 33]"));
        assertThat(list.toString(false), is("[33 22 11 10]"));
        it.nextLink();
        it.insertBefore(12);
        assertThat(list.toString(), is("[10 11 12 22 33]"));
        assertThat(list.toString(false), is("[33 22 12 11 10]"));
    }

    @Test
    public void testInsertAfterWhenEmpty() {
        list = new DoublyLinkedList();
        it = list.getIterator();
        it.insertAfter(42);
        assertThat(list.toString(), is("[42]"));
        assertThat(list.toString(false), is("[42]"));
        assertThat(it.getCurrent().data, is(42L));
    }

    @Test
    public void testInsertBeforeWhenEmpty() {
        list = new DoublyLinkedList();
        it = list.getIterator();
        it.insertBefore(42);
        assertThat(list.toString(), is("[42]"));
        assertThat(list.toString(false), is("[42]"));
        assertThat(it.getCurrent().data, is(42L));
    }

    @Test
    public void testDeleteCurrent() {
        it.nextLink();
        assertThat(list.toString(), is("[11 22 33]"));
        assertThat(list.toString(false), is("[33 22 11]"));
        assertThat(it.deleteCurrent(), is(22L));
        assertThat(it.getCurrent().data, is(33L));
        assertThat(list.toString(), is("[11 33]"));
        assertThat(list.toString(false), is("[33 11]"));
        assertThat(it.deleteCurrent(), is(33L));
        assertThat(list.toString(), is("[11]"));
        assertThat(list.toString(false), is("[11]"));
        it.reset();
        assertThat(it.deleteCurrent(), is(11L));
        assertThat(list.toString(), is("[]"));
        assertThat(list.toString(false), is("[]"));
    }

    @Test
    public void testDeleteCurrentWhenFirst() {
        assertThat(it.deleteCurrent(), is(11L));
        assertThat(list.toString(), is("[22 33]"));
        assertThat(list.toString(false), is("[33 22]"));
    }

    @Test
    public void testDeleteCurrentAfterDeleteWhenLast() {
        it.nextLink();
        assertThat(it.deleteCurrent(), is(22L));
        assertThat(it.deleteCurrent(), is(33L));
        assertThat(list.toString(), is("[11]"));
        assertThat(list.toString(false), is("[11]"));
    }
}

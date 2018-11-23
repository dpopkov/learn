package learn.dsai.ch05.doubleend;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class FirstLastListTest {
    private FirstLastList list = new FirstLastList();

    @Test
    public void testIsEmpty() {
        assertThat(list.isEmpty(), is(true));
        list.insertFirst(11);
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testInsertFirst() {
        list.insertFirst(11);
        assertThat(list.toString(), is("{11}"));
        list.insertFirst(22);
        assertThat(list.toString(), is("{22} {11}"));
    }

    @Test
    public void testInsertLast() {
        list.insertLast(22);
        assertThat(list.toString(), is("{22}"));
        list.insertLast(11);
        assertThat(list.toString(), is("{22} {11}"));
    }

    @Test
    public void testDeleteFirst() {
        list.insertFirst(11);
        list.insertFirst(22);
        assertThat(list.deleteFirst(), is(22));
        assertThat(list.deleteFirst(), is(11));
        assertThat(list.isEmpty(), is(true));
    }
}

package learn.dsai.ch05.adt.sorted;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortedListTest {
    private SortedList list = new SortedList();

    @Test
    public void testIsEmpty() {
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void testInsert() {
        list.insert(33);
        assertThat(list.toString(), is("{33}"));
        list.insert(22);
        assertThat(list.toString(), is("{22} {33}"));
        list.insert(44);
        assertThat(list.toString(), is("{22} {33} {44}"));
        list.insert(40);
        assertThat(list.toString(), is("{22} {33} {40} {44}"));
        list.insert(30);
        assertThat(list.toString(), is("{22} {30} {33} {40} {44}"));
    }

    @Test
    public void testRemove() {
        list.insert(33);
        list.insert(22);
        assertThat(list.remove(), is(22L));
        assertThat(list.toString(), is("{33}"));
        assertThat(list.remove(), is(33L));
        assertThat(list.isEmpty(), is(true));
    }
}

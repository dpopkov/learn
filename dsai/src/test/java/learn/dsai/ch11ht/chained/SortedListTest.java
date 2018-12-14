package learn.dsai.ch11ht.chained;

import learn.dsai.ch11ht.KeyLong;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class SortedListTest {

    @Test
    public void tstInsert() {
        SortedList list = new SortedList();
        assertThat(list.toString(), is("[]"));
        list.insert(new Link(11L));
        assertThat(list.toString(), is("[11]"));
        list.insert(new Link(22L));
        assertThat(list.toString(), is("[11, 22]"));
    }

    @Test
    public void testDelete() {
        SortedList list = new SortedList();
        list.insert(new Link(44L));
        list.insert(new Link(33L));
        list.insert(new Link(22L));
        list.insert(new Link(11L));
        assertThat(list.toString(), is("[11, 22, 33, 44]"));
        list.delete(22L);
        assertThat(list.toString(), is("[11, 33, 44]"));
        list.delete(44L);
        assertThat(list.toString(), is("[11, 33]"));
        list.delete(11L);
        assertThat(list.toString(), is("[33]"));
        KeyLong deleted = list.delete(33L);
        assertThat(list.toString(), is("[]"));
        assertThat(deleted.getKey(), is(33L));
    }

    @Test
    public void testFind() {
        SortedList list = new SortedList();
        list.insert(new Link(33L));
        list.insert(new Link(22L));
        list.insert(new Link(11L));
        assertThat(list.find(33L).getKey(), is(33L));
        assertThat(list.find(22L).getKey(), is(22L));
        assertThat(list.find(11L).getKey(), is(11L));
        assertNull(list.find(44L));
    }
}

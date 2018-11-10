package learn.dsai.ch02arrays.array2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class HighArrayTest {
    private HighArray arr;

    @Before
    public void setUp() {
        arr = new HighArray(10);
    }

    @Test
    public void whenInsertElement() {
        arr.insert(11);
        assertThat(arr.toString(), is("[11]"));
    }

    @Test
    public void whenDeleteElement() {
        arr.insert(11);
        assertThat(arr.toString(), is("[11]"));
        boolean r = arr.delete(11);
        assertTrue(r);
        assertThat(arr.toString(), is("[]"));
    }

    @Test
    public void whenDeleteElementFromTwo() {
        arr.insert(11);
        arr.insert(22);
        assertThat(arr.toString(), is("[11, 22]"));
        boolean r = arr.delete(11);
        assertTrue(r);
        assertThat(arr.toString(), is("[22]"));
    }

    @Test
    public void whenDeleteNonExisting() {
        arr.insert(11);
        boolean r = arr.delete(22);
        assertFalse(r);
        assertThat(arr.toString(), is("[11]"));
    }

    @Test
    public void whenFind() {
        arr.insert(11);
        arr.insert(22);
        assertTrue(arr.find(22));
    }

    @Test
    public void whenFindNonExisting() {
        arr.insert(11);
        arr.insert(22);
        assertFalse(arr.find(33));
    }

    @Test
    public void whenGetMaxFromEmpty() {
        assertThat(arr.getMax(), is(-1L));
    }

    @Test
    public void whenGetMax() {
        arr.insert(11L);
        arr.insert(22L);
        assertThat(arr.getMax(), is(22L));
    }

    @Test
    public void whenRemovingMaxFromEmpty() {
        long max = arr.removeMax();
        assertThat(max, is(-1L));
    }

    @Test
    public void whenRemovingMax() {
        arr.insert(11L);
        arr.insert(22L);
        long max = arr.removeMax();
        assertThat(max, is(22L));
        assertThat(arr.toString(), is("[11]"));
    }

    @Test
    public void testNoDuplicates() {
        arr.insert(12L);
        arr.insert(12L);
        arr.insert(11L);
        arr.insert(11L);
        arr.insert(12L);
        arr.insert(11L);
        arr.insert(12L);
        arr.insert(12L);
        arr.noDuplicates();
        assertThat(arr.toString(), is("[12, 11]"));
    }
}

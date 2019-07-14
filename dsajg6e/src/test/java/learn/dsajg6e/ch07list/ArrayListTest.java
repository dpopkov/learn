package learn.dsajg6e.ch07list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void whenAddToEndThenAdded() {
        List<Integer> list = new ArrayList<>();
        list.add(0, 10);
        list.add(1, 20);
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(20));
    }

    @Test
    public void whenAddInTheMiddleThenAdded() {
        List<Integer> list = new ArrayList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(1, 15);
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(15));
        assertThat(list.get(2), is(20));
    }

    @Test
    public void whenRemoveInTheMiddleThenRemoved() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Integer x = list.remove(1);
        assertThat(x, is(20));
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(30));
    }

    @Test
    public void whenAddBeyondCapacityThenGrow() {
        List<Integer> list = new ArrayList<>(1);
        list.add(10);
        list.add(20);
        list.add(30);
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(20));
        assertThat(list.get(2), is(30));
    }

    @Test
    public void whenIteratorThenReturnsWorkingIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        it.remove();
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(false));
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(30));
    }
}
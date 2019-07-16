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
        List<Integer> list = new ArrayList<>(1);
        list.add(0, 10);
        list.add(1, 20);
        list.add(1, 15);
        list.add(1, 12);
        list.add(1, 11);
        assertThat(list.size(), is(5));
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(11));
        assertThat(list.get(2), is(12));
        assertThat(list.get(3), is(15));
        assertThat(list.get(4), is(20));
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

    @Test
    public void whenTrimToSizeThenAllElementsRemain() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.trimToSize();
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(20));
        assertThat(list.get(2), is(30));
    }

    /* R-7.18 */
    @Test
    public void whenAddElementThenContainsIt() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        assertThat(list.contains(10), is(true));
        assertThat(list.contains(20), is(true));
    }

    @Test
    public void whenNotHavingElementsThenContainsReturnsFalse() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        assertThat(list.contains(10), is(false));
    }

    /* R-7.19 */
    @Test
    public void afterClearListIsEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        assertThat(list.isEmpty(), is(false));
        list.clear();
        assertThat(list.isEmpty(), is(true));
    }
}

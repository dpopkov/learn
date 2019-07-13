package learn.dsajg6e.ch07list.positional;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PositionalListTest {

    @Test
    public void canSortInNonDecreasingOrder() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(20);
        list.addLast(30);
        list.addLast(10);
        PositionalList.insertionSort(list);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.before(list.last()).getElement(), is(20));
        assertThat(list.last().getElement(), is(30));
    }

    @Test
    public void whenAlreadySortedThenDoesNotChange() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        PositionalList.insertionSort(list);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.before(list.last()).getElement(), is(20));
        assertThat(list.last().getElement(), is(30));
    }
}

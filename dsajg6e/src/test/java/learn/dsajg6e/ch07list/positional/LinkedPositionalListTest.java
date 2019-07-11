package learn.dsajg6e.ch07list.positional;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LinkedPositionalListTest {

    @Test
    public void canAddFirstElement() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p20 = list.addFirst(20);
        assertThat(list.first().getElement(), is(20));
        var p10 = list.addFirst(10);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.size(), is(2));
        assertThat(list.before(p20).getElement(), is(10));
        assertThat(list.after(p10).getElement(), is(20));
    }

    @Test
    public void canAddLastElement() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addLast(10);
        assertThat(list.last().getElement(), is(10));
        var p20 = list.addLast(20);
        assertThat(list.last().getElement(), is(20));
        assertThat(list.size(), is(2));
        assertThat(list.before(p20).getElement(), is(10));
        assertThat(list.after(p10).getElement(), is(20));
    }

    @Test
    public void canAddBefore() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p20 = list.addLast(20);
        var p10 = list.addBefore(p20, 10);
        assertThat(list.after(p10).getElement(), is(20));
        assertThat(list.before(p20).getElement(), is(10));
    }

    @Test
    public void canAddAfter() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        assertThat(list.after(p10).getElement(), is(20));
        assertThat(list.before(p20).getElement(), is(10));
    }

    @Test
    public void canSetElements() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        Integer x = list.set(p10, 11);
        assertThat(x, is(10));
        assertThat(list.before(p20).getElement(), is(11));
    }

    @Test
    public void canRemoveElements() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        var p10 = list.addFirst(10);
        var p20 = list.addAfter(p10, 20);
        var p30 = list.addAfter(p20, 30);
        Integer removed = list.remove(p20);
        assertThat(removed, is(20));
        assertThat(list.after(p10).getElement(), is(30));
        assertThat(list.before(p30).getElement(), is(10));
        assertThat(list.size(), is(2));
        list.remove(p10);
        list.remove(p30);
        assertThat(list.isEmpty(), is(true));
    }
}

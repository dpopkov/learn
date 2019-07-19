package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0743PositionalArrayListTest {
    @Test
    public void canAddElements() {
        C0743PositionalArrayList<Integer> list = new C0743PositionalArrayList<>(2);
        list.add(10);
        assertThat(list.last().getElement(), is(10));
        list.add(20);
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(20));
        assertThat(list.size(), is(2));
    }

    @Test
    public void whenAddBeforeThenElementsAreShifted() {
        C0743PositionalArrayList<Integer> list = new C0743PositionalArrayList<>(3);
        var p20 = list.add(20);
        var p19 = list.addBefore(p20, 19);
        var p18 = list.addBefore(p19, 18);
        assertThat(list.get(0), is(18));
        assertThat(list.get(1), is(19));
        assertThat(list.get(2), is(20));
        assertThat(p18.getIndex(), is(0));
        assertThat(p19.getIndex(), is(1));
        assertThat(p20.getIndex(), is(2));
        assertThat(list.size(), is(3));
    }
}

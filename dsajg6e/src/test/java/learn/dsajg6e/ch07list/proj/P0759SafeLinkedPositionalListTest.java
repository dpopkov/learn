package learn.dsajg6e.ch07list.proj;

import learn.dsajg6e.ch07list.positional.PositionalList;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0759SafeLinkedPositionalListTest {
    @Test
    public void canAddElements() {
        PositionalList<Integer> list = new P0759SafeLinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.after(list.first()).getElement(), is(20));
        assertThat(list.toString(), is("[10, 20]"));
    }

    @Test
    public void canInsertAfterPosition() {
        PositionalList<Integer> list = new P0759SafeLinkedPositionalList<>();
        var p10 = list.addLast(10);
        list.addLast(20);
        list.addAfter(p10, 15);
        assertThat(list.toString(), is("[10, 15, 20]"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUsingPositionOfOtherListThenException() {
        PositionalList<Integer> list1 = new P0759SafeLinkedPositionalList<>();
        var p10 = list1.addLast(10);
        list1.addLast(20);
        assertThat(list1.toString(), is("[10, 20]"));
        PositionalList<Integer> list2 = new P0759SafeLinkedPositionalList<>();
        list2.addLast(100);
        assertThat(list2.toString(), is("[100]"));
        list2.addAfter(p10, 15);
    }
}

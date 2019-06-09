package learn.dsajg6e.ch03fund.linked;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        assertThat(list.toString(), is("[1, 2, 3]"));
        Integer x = list.remove();
        assertThat(x, is(1));
        assertThat(list.toString(), is("[2, 3]"));
        x = list.remove();
        assertThat(x, is(2));
        assertThat(list.toString(), is("[3]"));
        x = list.remove();
        assertThat(x, is(3));
        assertThat(list.toString(), is("[]"));
        assertThat(list.size(), is(0));
    }
}

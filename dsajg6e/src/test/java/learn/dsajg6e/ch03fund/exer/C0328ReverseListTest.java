package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0328ReverseListTest {

    @Test
    public void testAdd() {
        C0328ReverseList list = new C0328ReverseList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.toString(), is("[3, 2, 1]"));
    }

    @Test
    public void testReverse() {
        C0328ReverseList list = new C0328ReverseList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.reverse();
        assertThat(list.toString(), is("[1, 2, 3]"));
    }
}

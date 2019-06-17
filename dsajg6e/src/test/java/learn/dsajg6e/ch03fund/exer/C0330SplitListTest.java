package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0330SplitListTest {

    @Test
    public void testSplit() {
        var list1 = new C0330SplitList<Integer>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        var list2 = list1.split();
        assertThat(list2.size(), is(2));
        assertThat(list2.first(), is(1));
        assertThat(list2.last(), is(2));
        assertThat(list1.size(), is(2));
        assertThat(list1.first(), is(3));
        assertThat(list1.last(), is(4));
    }
}
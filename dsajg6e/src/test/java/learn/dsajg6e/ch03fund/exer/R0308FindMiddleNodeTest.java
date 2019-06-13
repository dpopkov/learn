package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0308FindMiddleNodeTest {

    @Test
    public void testFindMiddle() {
        R0308FindMiddleNode<Integer> list = new R0308FindMiddleNode<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        assertThat(list.findMiddle(), is(2));
        list.addLast(4);
        assertThat(list.findMiddle(), is(2));
        list.addLast(5);
        assertThat(list.findMiddle(), is(3));
    }
}
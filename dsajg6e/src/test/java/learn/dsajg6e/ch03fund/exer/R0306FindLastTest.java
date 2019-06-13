package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0306FindLastTest {

    @Test
    public void testFindNthLastElement() {
        R0306FindLast<Integer> list = new R0306FindLast<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThat(list.findNthLastElement(1), is(3));
        assertThat(list.findNthLastElement(2), is(2));
        assertThat(list.findNthLastElement(3), is(1));
    }
}
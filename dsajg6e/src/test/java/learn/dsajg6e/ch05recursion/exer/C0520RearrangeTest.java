package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0520Rearrange.*;
import static learn.dsajg6e.tools.ArrayTools.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0520RearrangeTest {

    @Test
    public void testRearrange() {
        int[] a = {1, 2};
        rearrange(a);
        assertThat(a, is(new int[]{2, 1}));
        int[] b = {1, 2, 4};
        rearrange(b);
        assertThat(b, is(new int[]{2, 4, 1}));
    }

    @Test
    public void testRearrangeLongSequence() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        rearrange(a);
        int[][] rst = split(a, 4);
        int[] head = rst[0];
        int[] tail = rst[1];
        assertTrue(allEven(head));
        assertTrue(allOdd(tail));
    }
}

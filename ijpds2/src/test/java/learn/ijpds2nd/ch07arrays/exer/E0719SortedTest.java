package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0719SortedTest {

    @Test
    public void testIsSorted() {
        E0719Sorted s = new E0719Sorted();
        int[] a1 = {3, 2};
        assertFalse(s.isSorted(a1, (p, c) -> p > c));
        int[] a2 = {1, 2};
        assertTrue(s.isSorted(a2, (p, c) -> p > c));
    }
}

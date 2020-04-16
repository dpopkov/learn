package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0727SortedWithConstantTest {

    @Test
    public void testSortedWithConstant() {
        int[] a = {1, 2, 5};
        E0727SortedWithConstant sc = new E0727SortedWithConstant();
        assertFalse(sc.sortedWithConstant(a));
        int[] b = {3, 5, 7};
        assertTrue(sc.sortedWithConstant(b));
    }
}

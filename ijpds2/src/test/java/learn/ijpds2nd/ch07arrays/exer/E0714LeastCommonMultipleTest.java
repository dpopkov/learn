package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static learn.ijpds2nd.ch07arrays.exer.E0714LeastCommonMultiple.*;
import static org.junit.Assert.*;

public class E0714LeastCommonMultipleTest {

    @Test
    public void testFindLeastCommonMultiple() {
        assertEquals(12, findLeastCommonMultiple(new int[]{3, 4}));
        assertEquals(12, findLeastCommonMultiple(new int[]{6, 4}));
        assertEquals(30, findLeastCommonMultiple(new int[]{2, 3, 5}));
    }
}

package learn.mutumju.ch01recall;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Demonstrates verifying test conditions with Assertion methods.
 */
public class AssertTest {
    @Test
    public void testAssertTrueAndFalse() {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void testAssertNullAndNotNull() {
        Object obj = null;
        assertNull(obj);
        obj = "Some value";
        assertNotNull(obj);
    }

    @Test
    public void testAssertEquals() {
        Integer i = Integer.parseInt("5");
        Integer j = Integer.parseInt("4") + 1;
        assertEquals(i, j);
        assertSame(i, j);
    }

    @Test
    public void testAssertNotSame() {
        String s1 = "first";
        String s2 = "firs" + (Math.random() < 1 ? "t" : "");
        assertEquals(s1, s2);
        assertNotSame(s1, s2);
    }
}

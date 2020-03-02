package learn.hfdp.ch07adapter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IteratorEnumerationTest {

    @Test
    public void canCheckThatHasMoreElementsAndReturnNext() {
        List<Integer> list = List.of(1, 2);
        IteratorEnumeration<Integer> en = new IteratorEnumeration<>(list.iterator());
        assertTrue(en.hasMoreElements());
        assertEquals(Integer.valueOf(1), en.nextElement());
        assertTrue(en.hasMoreElements());
        assertEquals(Integer.valueOf(2), en.nextElement());
        assertFalse(en.hasMoreElements());
    }
}

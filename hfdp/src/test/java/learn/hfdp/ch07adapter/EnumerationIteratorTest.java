package learn.hfdp.ch07adapter;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class EnumerationIteratorTest {

    @Test
    public void canCheckNextAndReturnNext() {
        Vector<Integer> vector = new Vector<>();
        vector.add(11);
        vector.add(22);
        EnumerationIterator<Integer> adapter = new EnumerationIterator<>(vector.elements());
        assertTrue(adapter.hasNext());
        assertEquals(Integer.valueOf(11), adapter.next());
        assertTrue(adapter.hasNext());
        assertEquals(Integer.valueOf(22), adapter.next());
        assertFalse(adapter.hasNext());
    }
}

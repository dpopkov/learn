package learn.hfdp.ch09iterator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DinnerMenuIteratorTest {

    @Test
    public void whenNextThenReturnsNextElement() {
        MenuItem item1 = new MenuItem("n1", "d1", true, 1.2);
        MenuItem item2 = new MenuItem("n2", "d2", false, 2.3);
        MenuItem[] items = new MenuItem[] {item1, item2};
        DinnerMenuIterator it = new DinnerMenuIterator(items, 2);
        assertTrue(it.hasNext());
        assertEquals("n1", it.next().getName());
        assertTrue(it.hasNext());
        assertEquals("n2", it.next().getName());
        assertFalse(it.hasNext());
    }
}

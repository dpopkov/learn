package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.AbstractMap;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1051SortedTableMapWithLazyIteratorTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testEntrySet() {
        var map = new C1051SortedTableMapWithLazyIterator<Integer, String>();
        map.put(1, "1");
        map.put(4, "4");
        map.put(2, "2");
        map.put(3, "3");
        var iterable = map.entrySet();
        assertThat(iterable, containsInAnyOrder(
                new AbstractMap.MapEntry<>(1, "1"),
                new AbstractMap.MapEntry<>(2, "2"),
                new AbstractMap.MapEntry<>(3, "3"),
                new AbstractMap.MapEntry<>(4, "4")
        ));
    }
}

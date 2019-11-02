package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.AbstractMap.MapEntry;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1052ChainHashMapWithLazyIteratorTest {

    @Test
    public void testEntrySetOfOneElement() {
        var map = new C1052ChainHashMapWithLazyIterator<Integer, String>();
        map.put(1, "1");
        var iterable = map.entrySet();
        var iterator = iterable.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getKey(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testEntrySet() {
        var map = new C1052ChainHashMapWithLazyIterator<Integer, String>();
        map.put(1, "1");
        map.put(4, "4");
        map.put(2, "2");
        map.put(3, "3");
        var iterable = map.entrySet();
        assertThat(iterable, containsInAnyOrder(
                new MapEntry<>(1, "1"),
                new MapEntry<>(2, "2"),
                new MapEntry<>(3, "3"),
                new MapEntry<>(4, "4")
        ));
    }
}

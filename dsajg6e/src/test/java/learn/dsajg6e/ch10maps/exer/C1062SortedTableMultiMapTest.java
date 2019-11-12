package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.MultiMap;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1062SortedTableMultiMapTest {

    @Test
    public void canPutAndGet() {
        MultiMap<Integer, String> map = new C1062SortedTableMultiMap<>(10);
        assertTrue(map.isEmpty());
        map.put(10, "10");
        map.put(20, "20");
        map.put(10, "Десять");
        map.put(10, "Ten");
        map.put(20, "Twenty");
        Iterable<String> tens = map.get(10);
        assertThat(tens, containsInAnyOrder("10", "Ten", "Десять"));
        Iterable<String> twenties = map.get(20);
        assertThat(twenties, containsInAnyOrder("20", "Twenty"));
        assertThat(map.size(), is(5));
    }

    @Test
    public void canRemove() {
        MultiMap<Integer, String> map = new C1062SortedTableMultiMap<>(10);
        map.put(10, "10");
        map.put(20, "20");
        map.put(10, "Десять");
        map.put(10, "Ten");
        map.put(20, "Twenty");
        assertThat(map.size(), is(5));
        boolean rst = map.remove(10, "Ten");
        assertTrue(rst);
        rst = map.remove(20, "20");
        assertTrue(rst);
        rst = map.remove(30, "30");
        assertFalse(rst);
        assertThat(map.size(), is(3));
        Iterable<String> tens = map.get(10);
        assertThat(tens, containsInAnyOrder("10", "Десять"));
        Iterable<String> twenties = map.get(20);
        assertThat(twenties, containsInAnyOrder("Twenty"));
    }
}

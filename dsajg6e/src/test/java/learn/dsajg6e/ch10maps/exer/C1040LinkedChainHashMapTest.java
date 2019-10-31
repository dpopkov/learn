package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.Map;
import org.junit.Test;

import java.util.NavigableMap;
import java.util.TreeMap;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1040LinkedChainHashMapTest {

    @Test
    public void canPutAngGet() {
        Map<Integer, String> map = new C1040LinkedChainHashMap<>(7, 0.75, 1000, 1, 0);
        map.put(3, "3");
        map.put(10, "101");
        map.put(10, "10");
        map.put(20, "20");
        assertThat(map.size(), is(3));
        assertThat(map.get(3), is("3"));
        assertThat(map.get(10), is("10"));
        assertThat(map.get(20), is("20"));
    }

    @Test
    public void canPutIfAbsent() {
        C1040LinkedChainHashMap<Integer, String> map = new C1040LinkedChainHashMap<>(7, 0.75, 1000, 1, 0);
        map.put(3, "3");
        map.putIfAbsent(10, "10");
        map.putIfAbsent(10, "101");
        map.putIfAbsent(20, "20");
        assertThat(map.size(), is(3));
        assertThat(map.get(3), is("3"));
        assertThat(map.get(10), is("10"));
        assertThat(map.get(20), is("20"));
    }

    @Test
    public void canReturnEntrySet() {
        Map<Integer, String> map = new C1040LinkedChainHashMap<>();
        map.put(2, "2");
        map.put(3, "3");
        map.put(1, "1");
        Iterable<Entry<Integer, String>> entries = map.entrySet();
        NavigableMap<Integer, Entry<Integer, String>> sorted = new TreeMap<>();
        for (var e : entries) {
            sorted.put(e.getKey(), e);
        }
        Integer key = sorted.firstKey();
        assertThat(sorted.get(key).getKey(), is(1));
        assertThat(sorted.get(key).getValue(), is("1"));
        key = sorted.higherKey(key);
        assertThat(sorted.get(key).getKey(), is(2));
        assertThat(sorted.get(key).getValue(), is("2"));
        key = sorted.higherKey(key);
        assertThat(sorted.get(key).getKey(), is(3));
        assertThat(sorted.get(key).getValue(), is("3"));
    }

    @Test
    public void canRemove() {
        Map<Integer, String> map = new C1040LinkedChainHashMap<>(7, 0.75, 1000, 1, 0);
        map.put(3, "3");
        map.put(10, "10");
        map.put(20, "20");
        assertThat(map.size(), is(3));
        assertThat(map.remove(10), is("10"));
        assertThat(map.size(), is(2));
        assertThat(map.remove(3), is("3"));
        assertThat(map.size(), is(1));
        assertNull(map.remove(3));
        assertThat(map.remove(20), is("20"));
        assertThat(map.size(), is(0));
    }
}

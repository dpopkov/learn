package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.Map;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P1067LinkedHashMapTest {

    @Test
    public void canPutAndGet() {
        Map<Integer, String> map = new P1067LinkedHashMap<>();
        map.put(20, "20");
        map.put(10, "10");
        map.put(10, "101");
        map.put(30, "30");
        assertThat(map.size(), is(3));
        assertThat(map.get(10), is("101"));
        assertThat(map.get(20), is("20"));
        assertThat(map.get(30), is("30"));
    }

    @Test
    public void canPutIntoSameBucketAndGet() {
        Map<Integer, String> map = new P1067LinkedHashMap<>(10, 0.7, 1000, 1, 0);
        map.put(12, "12");
        map.put(10, "10");
        map.put(20, "20");
        map.put(15, "15");
        assertThat(map.size(), is(4));
        assertThat(map.get(10), is("10"));
        assertThat(map.get(20), is("20"));
        assertThat(map.get(12), is("12"));
        assertThat(map.get(15), is("15"));
    }

    @Test
    public void canPutAndIterateInOrder() {
        Map<Integer, String> map = new P1067LinkedHashMap<>(10, 0.7, 1000, 1, 0);
        map.put(10, "10");
        map.put(12, "12");
        map.put(15, "15");
        map.put(20, "20");
        assertThat(map.size(), is(4));
        assertThat(map.keySet(), contains(10, 12, 15, 20));
        assertThat(map.values(), contains("10", "12", "15", "20"));
    }

    @Test
    public void canIterateAfterPut() {
        Map<Integer, String> map = new P1067LinkedHashMap<>(10, 0.7, 1000, 1, 0);
        map.put(10, "10");
        map.put(12, "12");
        assertThat(map.size(), is(2));
        assertThat(map.keySet(), contains(10, 12));
        assertThat(map.values(), contains("10", "12"));
        map.put(15, "15");
        map.put(20, "20");
        assertThat(map.size(), is(4));
        assertThat(map.keySet(), contains(10, 12, 15, 20));
        assertThat(map.values(), contains("10", "12", "15", "20"));
    }

    @Test
    public void canRemove() {
        Map<Integer, String> map = new P1067LinkedHashMap<>(1);
        map.put(10, "10");
        map.put(12, "12");
        map.put(15, "15");
        map.put(20, "20");
        assertThat(map.size(), is(4));
        assertThat(map.keySet(), contains(10, 12, 15, 20));
        assertThat(map.values(), contains("10", "12", "15", "20"));
        map.remove(12);
        assertThat(map.size(), is(3));
        assertThat(map.keySet(), contains(10, 15, 20));
        assertThat(map.values(), contains("10", "15", "20"));
        map.remove(20);
        assertThat(map.size(), is(2));
        assertThat(map.keySet(), contains(10, 15));
        assertThat(map.values(), contains("10", "15"));
        map.remove(10);
        assertThat(map.size(), is(1));
        assertThat(map.keySet(), contains(15));
        assertThat(map.values(), contains("15"));
        map.remove(15);
        assertTrue(map.isEmpty());
    }
}

package learn.dsajg6e.ch10maps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProbeHashMapTest {

    @Test
    public void canPutAndGet() {
        Map<String, Integer> map = new ProbeHashMap<>();
        assertThat(map.isEmpty(), is(true));
        map.put("1", 1);
        map.put("3", 3);
        map.put("2", 2);
        assertThat(map.size(), is(3));
        assertThat(map.get("1"), is(1));
        assertThat(map.get("2"), is(2));
        assertThat(map.get("3"), is(3));
        map.remove("2");
        assertNull(map.get("2"));
        assertThat(map.size(), is(2));
    }

    /* C-10.35 */
    @Test
    public void canPutIfAbsent() {
        ProbeHashMap<String, Integer> map = new ProbeHashMap<>();
        map.put("1", 1);
        Integer value = map.putIfAbsent("1", 11);
        assertThat(value, is(1));
        assertThat(map.get("1"), is(1));
        value = map.putIfAbsent("2", 2);
        assertNull(value);
        assertThat(map.get("2"), is(2));
    }

    /* C-10.36 */
    @Test
    public void testContainsKey() {
        ProbeHashMap<String, Integer> map = new ProbeHashMap<>();
        map.put("1", 1);
        assertThat(map.containsKey("1"), is(true));
        assertThat(map.containsKey("2"), is(false));
    }

    @Test
    public void whenMapIsBiggerThanCapacityThenResize() {
        ProbeHashMap<String, Integer> map = new ProbeHashMap<>(3, 0.5);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        assertThat(map.size(), is(4));
        assertThat(map.get("1"), is(1));
        assertThat(map.get("2"), is(2));
        assertThat(map.get("3"), is(3));
        assertThat(map.get("4"), is(4));
    }
}

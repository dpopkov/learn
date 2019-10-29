package learn.dsajg6e.ch10maps;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ChainHashMapTest {

    @Test
    public void canPutAndGet() {
        Map<String, Integer> map = new ChainHashMap<>();
        assertThat(map.isEmpty(), is(true));
        map.put("1", 1);
        map.put("3", 3);
        map.put("2", 2);
        assertThat(map.size(), is(3));
        assertThat(map.get("1"), is(1));
        assertThat(map.get("2"), is(2));
        assertThat(map.get("3"), is(3));
    }

    /* C-10.34 */
    @Test
    public void testPutIfAbsent() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        map.put("1", 1);
        Integer value = map.putIfAbsent("1", 11);
        assertThat(value, is(1));
        assertThat(map.get("1"), is(1));
        value = map.putIfAbsent("2", 2);
        assertNull(value);
        assertThat(map.get("2"), is(2));
    }
}

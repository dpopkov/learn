package learn.dsajg6e.ch11searchtrees;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TreeMapTest {

    @Test
    public void canPutAndGet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        assertPutGet(map, 10, "10", 1);
        assertPutGet(map, 20, "20", 2);
        assertPutGet(map, 30, "30", 3);
    }

    @Test
    public void canReturnFloorEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        assertPutGet(map, 10, "10", 1);
        assertPutGet(map, 30, "30", 2);
        assertPutGet(map, 20, "20", 3);
        // todo: finish this test
        assertThat(map.floorEntry(21).getValue(), is("20"));
        assertThat(map.floorEntry(20).getValue(), is("20"));
    }

    private void assertPutGet(TreeMap<Integer, String> map, int key, String value, int size) {
        map.put(key, value);
        assertThat(map.size(), is(size));
        assertThat(map.get(key), is(value));
    }
}

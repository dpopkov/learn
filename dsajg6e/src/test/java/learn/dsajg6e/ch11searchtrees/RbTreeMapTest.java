package learn.dsajg6e.ch11searchtrees;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RbTreeMapTest {

    @Test
    public void canInsert() {
        TreeMap<Integer, String> map = new RbTreeMap<>();
        assertPutGet(map,10, "10", 1);
    }

    // todo: add tests

    private void assertPutGet(TreeMap<Integer, String> map, int key, String value, int size) {
        map.put(key, value);
        assertThat(map.size(), is(size));
        assertThat(map.get(key), is(value));
    }
}
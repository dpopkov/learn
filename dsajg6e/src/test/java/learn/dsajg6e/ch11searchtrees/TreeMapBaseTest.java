package learn.dsajg6e.ch11searchtrees;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeMapBaseTest {

    protected <K, V> void assertPutGet(TreeMap<K, V> map, K key, V value, int size) {
        map.put(key, value);
        assertThat(map.size(), is(size));
        assertThat(map.get(key), is(value));
    }
}

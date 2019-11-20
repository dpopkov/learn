package learn.dsajg6e.ch11searchtrees;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AvlTreeMapTest {

    @Test
    public void canPutAndGet() {
        TreeMap<Integer, String> map = new AvlTreeMap<>();
        assertPutGet(map, 10, "10", 1);
        assertPutGet(map, 20, "20", 2);
        assertPutGet(map, 30, "30", 3);
        assertPutGet(map, 40, "40", 4);
    }

    @Test
    public void canRemove() {
        Comparator<Integer> integerReversedComparator = Comparator.reverseOrder();
        TreeMap<Integer, String> map = new AvlTreeMap<>(integerReversedComparator);
        map.put(10, "10");
        map.put(20, "20");
        map.put(30, "30");
        map.put(40, "40");
        assertThat(map.remove(20), is("20"));
        assertContainsAll(map, 10, "10", 30, "30", 40, "40");
        assertThat(map.remove(30), is("30"));
        assertContainsAll(map, 10, "10", 40, "40");
        assertThat(map.remove(10), is("10"));
        assertContainsAll(map,40, "40");
        assertThat(map.remove(40), is("40"));
        assertTrue(map.isEmpty());
    }

    private void assertContainsAll(TreeMap<Integer, String> map, Object ... keyValues) {
        assertThat(map.size(), is(keyValues.length / 2));
        for (int i = 0; i < keyValues.length; i += 2) {
            assertThat(map.get((Integer) keyValues[i]), is(keyValues[i + 1]));
        }
    }

    private void assertPutGet(TreeMap<Integer, String> map, int key, String value, int size) {
        map.put(key, value);
        assertThat(map.size(), is(size));
        assertThat(map.get(key), is(value));
    }
}
package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.AbstractMap;
import learn.dsajg6e.ch10maps.Map;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1041RearrangingProbeHashMapTest {

    @Test
    public void canPutAndGet() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>();
        map.put(1, "1");
        map.put(3, "3");
        map.put(2, "2");
        assertThat(map.size(), is(3));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        assertThat(map.get(3), is("3"));
    }

    @Test
    public void canPutWithSameKeyAndGet() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        assertThat(map.size(), is(2));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        map.put(2, "two");
        assertThat(map.size(), is(2));
        assertThat(map.get(2), is("two"));
    }

    @Test
    public void canPutWithCollisionAndGet() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>(10, 0.5, 1000, 1, 0);
        map.put(1, "1");
        map.put(2, "2");
        assertThat(map.size(), is(2));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        map.put(11, "11");
        assertThat(map.size(), is(3));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(11), is("11"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void canReturnEntrySet() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>();
        map.put(2, "2");
        map.put(1, "1");
        Iterable<Entry<Integer, String>> entries = map.entrySet();
        assertThat(entries, containsInAnyOrder(
                new AbstractMap.MapEntry<>(1, "1"),
                new AbstractMap.MapEntry<>(2, "2")
        ));
    }

    @Test
    public void canRemove() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>(10, 0.5, 1000, 1, 0);
        map.put(1, "1");
        map.put(2, "2");
        assertThat(map.size(), is(2));

        String v;
        v = map.remove(1);
        assertThat(v, is("1"));
        assertThat(map.size(), is(1));
        assertNull(map.get(1));

        v = map.remove(1);
        assertNull(v);
        assertThat(map.size(), is(1));
    }

    @Test
    public void canRemoveAfterPutWithCollision() {
        Map<Integer, String> map = new C1041RearrangingProbeHashMap<>(10, 0.5, 1000, 1, 0);
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(11, "11");
        map.put(21, "21");
        assertThat(map.size(), is(5));

        String v;
        v = map.remove(1);  // size=4 > 0.25*capacity
        assertThat(v, is("1"));
        assertThat(map.size(), is(4));
        assertNull(map.get(1));

        assertThat(map.get(11), is("11"));
        assertThat(map.get(21), is("21"));
        v = map.remove(11);
        assertThat(v, is("11"));
        assertThat(map.size(), is(3));

        assertThat(map.get(21), is("21"));
        v = map.remove(21);
        assertThat(v, is("21"));
        assertThat(map.size(), is(2));
    }
}

package learn.dsajg6e.ch10maps;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SortedTableMapTest {

    @Test
    public void canGetFirstEntry() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(2, "2");
        assertThat(map.firstEntry().getKey(), is(2));
        map.put(3, "3");
        assertThat(map.firstEntry().getKey(), is(2));
        map.put(1, "1");
        assertThat(map.firstEntry().getKey(), is(1));
    }

    @Test
    public void canGetLastEntry() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(2, "2");
        assertThat(map.lastEntry().getKey(), is(2));
        map.put(3, "3");
        assertThat(map.lastEntry().getKey(), is(3));
        map.put(1, "1");
        assertThat(map.lastEntry().getKey(), is(3));
    }

    @Test
    public void canGetByKey() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(3, "3");
        map.put(1, "1");
        map.put(2, "2");
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        assertThat(map.get(3), is("3"));
        assertNull(map.get(4));
    }

    @Test
    public void whenPutExistingThenReplaceValue() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(3, "3");
        map.put(1, "1");
        map.put(1, "11");
        assertThat(map.size(), is(2));
        assertThat(map.get(1), is("11"));
    }

    @Test
    public void canRemoveByKey() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(3, "3");
        map.put(2, "2");
        map.put(1, "1");
        assertThat(map.size(), is(3));
        map.remove(2);
        assertThat(map.size(), is(2));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(3), is("3"));
        assertNull(map.get(2));
    }

    @Test
    public void canFindCeiling() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(33, "3");
        map.put(22, "2");
        map.put(11, "1");
        assertThat(map.ceilingEntry(10).getKey(), is(11));
        assertThat(map.ceilingEntry(11).getKey(), is(11));
        assertThat(map.ceilingEntry(33).getKey(), is(33));
        assertThat(map.ceilingEntry(32).getKey(), is(33));
    }

    @Test
    public void canFindFloor() {
        SortedMap<Integer, String> map = new SortedTableMap<>();
        map.put(33, "3");
        map.put(22, "2");
        map.put(11, "1");
        assertThat(map.floorEntry(12).getKey(), is(11));
        assertThat(map.floorEntry(11).getKey(), is(11));
        assertThat(map.floorEntry(34).getKey(), is(33));
        assertThat(map.floorEntry(33).getKey(), is(33));
    }
}

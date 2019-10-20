package learn.dsajg6e.ch10maps;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UnsortedTableMapTest {

    @Test
    public void canPutKeyValuePairsAndGetByKey() {
        Map<Integer, String> map = new UnsortedTableMap<>();
        map.put(10, "Ten");
        map.put(30, "Thirty");
        map.put(20, "Twenty");
        assertThat(map.size(), is(3));
        assertThat(map.get(10), is("Ten"));
        assertThat(map.get(20), is("Twenty"));
        assertThat(map.get(30), is("Thirty"));

        Iterator<Integer> it = map.keySet().iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
        assertThat(it.next(), is(20));
        assertThat(it.hasNext(), is(false));
    }
}

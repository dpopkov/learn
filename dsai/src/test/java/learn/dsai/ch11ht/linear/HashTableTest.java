package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.DataItem;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testFindExisting() {
        DataItem[] items = new DataItem[] {null, null, new DataItem(10), new DataItem(14)};
        HashTable table = new HashTable(items, 2);
        DataItem result = table.find(10L);
        assertNotNull(result);
        assertThat(result.getKey(), is(10L));
        result = table.find(14L);
        assertNotNull(result);
        assertThat(result.getKey(), is(14L));
    }

    @Test
    public void testFindNonExisting() {
        DataItem[] items = new DataItem[] {null, null, new DataItem(10), new DataItem(14)};
        HashTable table = new HashTable(items, 2);
        DataItem result = table.find(4L);
        assertNull(result);
        result = table.find(18L);
        assertNull(result);
    }

    @Test
    public void testFindExistingWrappedAround() {
        DataItem[] items = new DataItem[] {new DataItem(18), null, new DataItem(10), new DataItem(14)};
        HashTable table = new HashTable(items, 3);
        DataItem result = table.find(18L);
        assertNotNull(result);
        assertThat(result.getKey(), is(18L));
    }
}

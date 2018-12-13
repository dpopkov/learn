package learn.dsai.ch11ht.doubleh;

import learn.dsai.ch11ht.DataItem;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testFindExisting() {
        DataItem[] items = new DataItem[] {
                null, null, null, new DataItem(10),
                new DataItem(11), null, new DataItem(17)
        };
        HashTable table = new HashTable(items, 3);
        DataItem result = table.find(10L);
        assertThat(result.getKey(), is(10L));
        result = table.find(17L);
        assertThat(result.getKey(), is(17L));
    }

    @Test
    public void testFindNonExisting() {
        DataItem[] items = new DataItem[] {
                null, null, new DataItem(9), null, null, null, new DataItem(16)};
        HashTable table = new HashTable(items, 2);
        DataItem result = table.find(1L);
        assertNull(result);
        result = table.find(23L);
        assertNull(result);
    }

    @Test
    public void testInsert() {
        HashTable table = new HashTable();
        table.insert(new DataItem(11L));
        DataItem found = table.find(11L);
        assertThat(found.getKey(), is(11L));
        table.insert(new DataItem(22L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(22L).getKey(), is(22L));
    }

    @Test
    public void testInsertAfterRehash() {
        HashTable table = new HashTable();
        long[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertInsertAll(table, values);
    }

    private void assertInsertAll(HashTable table, long[] values) {
        for (int i = 0; i < values.length; i++) {
            table.insert(new DataItem(values[i]));
            for (int j = 0; j <= i; j++) {
                DataItem found = table.find(values[j]);
                assertNotNull(found);
                assertThat(found.getKey(), is(values[j]));
                assertThat(table.getSize(), is(i + 1));
            }
        }
    }

    @Test
    public void testDelete() {
        HashTable table = new HashTable();
        table.insert(new DataItem(11L));
        table.insert(new DataItem(22L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(22L).getKey(), is(22L));
        DataItem deleted = table.delete(11L);
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is(11L));
        assertNull(table.find(11L));
        assertNull(table.delete(11L));
        deleted = table.delete(22L);
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is(22L));
        assertNull(table.find(22L));
        assertNull(table.delete(22L));
    }
}

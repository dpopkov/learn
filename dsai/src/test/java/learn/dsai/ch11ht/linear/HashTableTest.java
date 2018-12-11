package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.DataItem;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testFindExisting() {
        DataItem[] items = new DataItem[] {null, null, new DataItem(10), new DataItem(14)};
        HashTable table = new HashTable(items);
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
        HashTable table = new HashTable(items);
        DataItem result = table.find(4L);
        assertNull(result);
        result = table.find(18L);
        assertNull(result);
    }

    @Test
    public void testFindExistingWrappedAround() {
        DataItem[] items = new DataItem[] {new DataItem(18), null, new DataItem(10), new DataItem(14)};
        HashTable table = new HashTable(items);
        DataItem result = table.find(18L);
        assertNotNull(result);
        assertThat(result.getKey(), is(18L));
    }

    @Test
    public void testInsert() {
        HashTable table = new HashTable();
        table.insert(new DataItem(11L));
        DataItem found = table.find(11L);
        assertNotNull(found);
        assertThat(found.getKey(), is(11L));
        table.insert(new DataItem(21L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
    }

    @Test
    public void testInsertAfterRehash() {
        HashTable table = new HashTable(3);
        table.insert(new DataItem(11L));
        DataItem found = table.find(11L);
        assertNotNull(found);
        assertThat(found.getKey(), is(11L));
        table.insert(new DataItem(21L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));

        table.insert(new DataItem(22L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        assertThat(table.find(22L).getKey(), is(22L));

        table.insert(new DataItem(33L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        assertThat(table.find(22L).getKey(), is(22L));
        assertThat(table.find(33L).getKey(), is(33L));
        assertThat(table.getSize(), is(4));
    }

    @Test
    public void testDelete() {
        HashTable table = new HashTable();
        table.insert(new DataItem(11L));
        table.insert(new DataItem(21L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        DataItem deleted = table.delete(11L);
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is(11L));
        assertNull(table.find(11L));
        assertNull(table.delete(11L));
        deleted = table.delete(21L);
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is(21L));
        assertNull(table.find(21L));
        assertNull(table.delete(21L));
    }

    @Test
    public void testDeleteFromEmpty() {
        HashTable table = new HashTable(4);
        table.insert(new DataItem(1L));
        table.insert(new DataItem(4L));
        table.delete(1L);
        table.delete(4L);
        table.insert(new DataItem(3L));
        table.delete(3L);
        assertNull(table.delete(1L));
        assertNull(table.delete(4L));
        assertNull(table.delete(3L));
    }

    @Test
    public void testInsertAfterDeleted() {
        HashTable table = new HashTable(3);
        table.insert(new DataItem(1L));
        table.delete(1L);
        table.insert(new DataItem(4L));
        DataItem found = table.find(4L);
        assertNotNull(found);
        assertThat(found.getKey(), is(4L));
        assertThat(table.toString(), is("[** 4 **]"));
    }

    @Test
    public void testToString() {
        HashTable table = new HashTable(3);
        table.insert(new DataItem(4L));
        assertThat(table.toString(), is("[** 4 **]"));
        table.delete(4L);
        assertThat(table.toString(), is("[** ** **]"));
    }
}

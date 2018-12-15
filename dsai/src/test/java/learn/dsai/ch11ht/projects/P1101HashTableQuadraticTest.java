package learn.dsai.ch11ht.projects;

import learn.dsai.ch11ht.DataItem;
import learn.dsai.ch11ht.HashTableLong;
import learn.dsai.ch11ht.KeyLong;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P1101HashTableQuadraticTest {

    @Test
    public void testFindExisting() {
        DataItem[] items = new DataItem[] {null, null, new DataItem(10), new DataItem(14)};
        HashTableLong table = new P1101HashTableQuadratic(items, 2);
        KeyLong result = table.find(10L);
        assertNotNull(result);
        assertThat(result.getKey(), is(10L));
        result = table.find(14L);
        assertNotNull(result);
        assertThat(result.getKey(), is(14L));
    }

    @Test
    public void testFindNonExisting() {
        DataItem[] items = new DataItem[] {new DataItem(0), null, new DataItem(10), new DataItem(14)};
        HashTableLong table = new P1101HashTableQuadratic(items, 2);
        KeyLong result = table.find(4L);
        assertNull(result);
        result = table.find(18L);
        assertNull(result);
    }

    @Test
    public void testFindExistingWrappedAround() {
        DataItem[] items = new DataItem[] {new DataItem(18), null, new DataItem(10), new DataItem(14)};
        HashTableLong table = new P1101HashTableQuadratic(items, 3);
        KeyLong result = table.find(18L);
        assertNotNull(result);
        assertThat(result.getKey(), is(18L));
    }

    @Test
    public void testInsert() {
        HashTableLong table = new P1101HashTableQuadratic();
        table.insert(11L);
        assertThat(table.find(11L).getKey(), is(11L));
        table.insert(21L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
    }

    @Test
    public void testInsertAfterRehash() {
        HashTableLong table = new P1101HashTableQuadratic(3);
        table.insert(11L);
        assertThat(table.find(11L).getKey(), is(11L));
        table.insert(21L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));

        table.insert(22L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        assertThat(table.find(22L).getKey(), is(22L));

        table.insert(4L);
        assertThat(table.find(4L).getKey(), is(4L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        assertThat(table.find(22L).getKey(), is(22L));
        assertThat(table.getSize(), is(4));

        table.insert(33L);
        assertThat(table.find(4L).getKey(), is(4L));
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        assertThat(table.find(22L).getKey(), is(22L));
        assertThat(table.find(33L).getKey(), is(33L));
        assertThat(table.getSize(), is(5));
    }

    @Test
    public void testDelete() {
        HashTableLong table = new P1101HashTableQuadratic();
        table.insert(11L);
        table.insert(21L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(21L).getKey(), is(21L));
        KeyLong deleted = table.delete(11L);
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
        HashTableLong table = new P1101HashTableQuadratic(4);
        table.insert(1L);
        table.insert(4L);
        table.delete(1L);
        table.delete(4L);
        table.insert(3L);
        table.delete(3L);
        assertNull(table.delete(1L));
        assertNull(table.delete(4L));
        assertNull(table.delete(3L));
    }

    @Test
    public void testInsertAfterDeleted() {
        HashTableLong table = new P1101HashTableQuadratic(3);
        table.insert(1L);
        table.delete(1L);
        table.insert(4L);
        KeyLong found = table.find(4L);
        assertNotNull(found);
        assertThat(found.getKey(), is(4L));
        assertThat(table.toString(), is("[** 4 **]"));
    }

    @Test
    public void testToString() {
        HashTableLong table = new P1101HashTableQuadratic(3);
        table.insert(4L);
        assertThat(table.toString(), is("[** 4 **]"));
        table.delete(4L);
        assertThat(table.toString(), is("[** ** **]"));
    }
}

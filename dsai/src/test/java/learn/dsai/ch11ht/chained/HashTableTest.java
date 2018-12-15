package learn.dsai.ch11ht.chained;

import learn.dsai.ch11ht.KeyLong;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class HashTableTest {
    private final HashTable table = new HashTable(11);

    @Test
    public void testInsert() {
        table.insert(11L);
        KeyLong result = table.find(11L);
        assertThat(result.getKey(), is(11L));
        table.insert(22L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(22L).getKey(), is(22L));
    }

    @Test
    public void testDelete() {
        table.insert(11L);
        table.insert(22L);
        assertThat(table.find(11L).getKey(), is(11L));
        assertThat(table.find(22L).getKey(), is(22L));
        assertThat(table.delete(11L).getKey(), is(11L));
        assertNull(table.delete(11L));
        assertThat(table.delete(22L).getKey(), is(22L));
        assertNull(table.delete(22L));
    }

    @Test
    public void testGetSize() {
        assertThat(table.getSize(), is(0));
        table.insert(11L);
        assertThat(table.getSize(), is(1));
        table.insert(22L);
        assertThat(table.getSize(), is(2));
        table.delete(11L);
        table.delete(33L);
        assertThat(table.getSize(), is(1));
        table.delete(22L);
        assertThat(table.getSize(), is(0));
    }
}

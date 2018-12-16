package learn.dsai.ch11ht.projects;

import learn.dsai.ch11ht.DataItemT;
import learn.dsai.ch11ht.HashTableT;
import learn.dsai.ch11ht.KeyT;
import org.junit.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P1102HashTableLinearTest {
    private static DataItemT<String>[] createArray(String[] a) {
        @SuppressWarnings("unchecked")
        DataItemT<String>[] array = (DataItemT<String>[]) new DataItemT<?>[a.length];
        for (int i = 0; i < array.length; i++) {
            if (a[i] != null) {
                array[i] = new DataItemT<>(a[i]);
            }
        }
        return array;
    }

    private static final ToIntFunction<String> hashFunction = value -> {
        int hash = value.charAt(0) - '0';
        for (int i = 1; i < value.length(); i++) {
            hash = hash * 10 + value.charAt(i) - '0';
        }
        return hash;
    };

    @Test
    public void testFind() {
        DataItemT<String>[] items = createArray(new String[] {"22", null, "10", "14"});
        HashTableT<String> table = new P1102HashTableLinear<>(items, 2, hashFunction);
        assertThat(table.find("10").getKey(), is("10"));
        assertThat(table.find("14").getKey(), is("14"));
        assertThat(table.find("22").getKey(), is("22"));
        assertNull(table.find("4"));
        assertNull(table.find("18"));
    }

    @Test
    public void testInsert() {
        HashTableT<String> table = new P1102HashTableLinear<>(7, hashFunction);
        table.insert("7");
        assertThat(table.find("7").getKey(), is("7"));
        table.insert("14");
        assertThat(table.find("7").getKey(), is("7"));
        assertThat(table.find("14").getKey(), is("14"));
        table.insert("21");
        assertThat(table.find("7").getKey(), is("7"));
        assertThat(table.find("14").getKey(), is("14"));
        assertThat(table.find("21").getKey(), is("21"));
        table.insert("28");
        assertThat(table.find("7").getKey(), is("7"));
        assertThat(table.find("14").getKey(), is("14"));
        assertThat(table.find("21").getKey(), is("21"));
        assertThat(table.find("28").getKey(), is("28"));
        table.insert("35");
        assertThat(table.find("7").getKey(), is("7"));
        assertThat(table.find("14").getKey(), is("14"));
        assertThat(table.find("21").getKey(), is("21"));
        assertThat(table.find("28").getKey(), is("28"));
        assertThat(table.find("35").getKey(), is("35"));
        assertThat(table.getSize(), is(5));
    }

    @Test
    public void testDelete() {
        HashTableT<String> table = new P1102HashTableLinear<>(7, hashFunction);
        table.insert("7");
        table.insert("14");
        assertThat(table.find("7").getKey(), is("7"));
        assertThat(table.find("14").getKey(), is("14"));
        KeyT<String> deleted = table.delete("7");
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is("7"));
        assertNull(table.find("7"));
        assertNull(table.delete("7"));
        deleted = table.delete("14");
        assertNotNull(deleted);
        assertThat(deleted.getKey(), is("14"));
        assertNull(table.find("14"));
        assertNull(table.delete("14"));
    }
}

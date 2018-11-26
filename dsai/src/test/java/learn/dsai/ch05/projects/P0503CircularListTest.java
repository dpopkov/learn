package learn.dsai.ch05.projects;

import learn.dsai.ch05.adt.Link;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0503CircularListTest {
    private final P0503CircularList list = new P0503CircularList();

    @Test
    public void testInsert() {
        assertThat(list.toString(), is(""));
        list.insert(11);
        assertThat(list.toString(), is("11"));
        list.insert(33);
        assertThat(list.toString(), is("11 33"));
        list.insert(22);
        assertThat(list.toString(), is("11 22 33"));
    }

    @Test
    public void testStep() {
        list.insert(11);
        assertThat(list.getCurrent(), is(11L));
        list.insert(22);
        assertThat(list.getCurrent(), is(11L));
        list.step();
        assertThat(list.getCurrent(), is(22L));
        list.step();
        assertThat(list.getCurrent(), is(11L));
    }

    @Test
    public void testSearch() {
        assertNull(list.search(11));
        list.insert(11);
        Link result = list.search(11);
        assertNotNull(result);
        assertThat(result.data, is(11L));
        list.insert(22);
        result = list.search(22);
        assertNotNull(result);
        assertThat(result.data, is(22L));
        result = list.search(33);
        assertNull(result);
    }


    @Test
    public void testDeleteByFirst() {
        list.insert(11);
        list.insert(22);
        assertThat(list.toString(), is("11 22"));
        assertThat(list.deleteBy(11), is(true));
        assertThat(list.getCurrent(), is(22L));
        assertThat(list.toString(), is("22"));
    }

    @Test
    public void testDeleteBy() {
        boolean result;
        list.insert(11);
        result = list.deleteBy(22);
        assertThat(result, is(false));
        assertThat(list.toString(), is("11"));

        list.insert(22);
        assertThat(list.toString(), is("11 22"));
        result = list.deleteBy(22);
        assertThat(result, is(true));
        assertThat(list.getCurrent(), is(11L));
        assertThat(list.toString(), is("11"));

        result = list.deleteBy(11);
        assertThat(result, is(true));
        assertThat(list.toString(), is(""));
    }

    @Test
    public void testDelete() {
        list.insert(11);
        list.insert(33);
        list.insert(22);
        assertThat(list.delete(), is(22L));
        assertThat(list.delete(), is(33L));
        assertThat(list.delete(), is(11L));
        assertThat(list.isEmpty(), is(true));
    }
}

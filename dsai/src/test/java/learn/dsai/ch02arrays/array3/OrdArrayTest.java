package learn.dsai.ch02arrays.array3;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class OrdArrayTest {
    private OrdArray arr = new OrdArray(10);

    @Test
    public void whenInsert() {
        arr.insert(11L);
        assertThat(arr.toString(), is("[11]"));
    }

    @Test
    public void whenInsertNotInOrder() {
        arr.insert(22L);
        assertThat(arr.toString(), is("[22]"));
        arr.insert(11L);
        assertThat(arr.toString(), is("[11, 22]"));
    }

    @Test
    public void whenInsertThreeNotInOrder() {
        arr.insert(33L);
        assertThat(arr.toString(), is("[33]"));
        arr.insert(22L);
        assertThat(arr.toString(), is("[22, 33]"));
        arr.insert(11L);
        assertThat(arr.toString(), is("[11, 22, 33]"));
    }

    @Test
    public void whenFindNonExisting() {
        assertThat(arr.find(11), is(-1));
    }

    @Test
    public void whenFindInTheMiddle() {
        arr.insert(33L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.find(22L), is(1));
    }

    @Test
    public void whenFindAtTheBeginning() {
        arr.insert(33L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.find(11L), is(0));
    }

    @Test
    public void whenFindAtTheEnd() {
        arr.insert(33L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.find(33L), is(2));
    }

    @Test
    public void whenFindNonExistingInTheMiddle() {
        arr.insert(33L);
        arr.insert(30L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.find(31L), is(-4));
    }

    @Test
    public void whenDeleteNonExistingThenFalse() {
        arr.insert(33L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.delete(31L), is(false));
    }

    @Test
    public void whenDeleteExistingThenTrueAndDeleted() {
        arr.insert(33L);
        arr.insert(22L);
        arr.insert(11L);
        assertThat(arr.toString(), is("[11, 22, 33]"));
        assertThat(arr.delete(22L), is(true));
        assertThat(arr.toString(), is("[11, 33]"));
    }

    @Test
    public void whenSize() {
        assertThat(arr.size(), is(0));
        arr.insert(33L);
        assertThat(arr.size(), is(1));
    }
}

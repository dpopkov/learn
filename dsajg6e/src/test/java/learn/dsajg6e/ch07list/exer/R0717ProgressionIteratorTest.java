package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R0717ProgressionIteratorTest {

    @Test
    public void canIterateAndReturnSequenceOfNumbers() {
        Iterator<Long> it = new R0717ProgressionIterator();
        assertThat(it.next(), is(0L));
        assertThat(it.next(), is(1L));
        assertThat(it.next(), is(2L));
        assertThat(it.hasNext(), is(true));
    }
}

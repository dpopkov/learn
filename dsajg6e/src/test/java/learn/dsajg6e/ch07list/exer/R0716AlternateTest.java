package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class R0716AlternateTest {
    @Test
    public void whenIteratingThenReturnOnlyEvenIndexElements() {
        R0716Alternate<Integer> list = new R0716Alternate<>();
        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(14));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIteratingOverOddNumberOfElementsThenReturnOnlyEvenIndexElements() {
        R0716Alternate<Integer> list = new R0716Alternate<>();
        list.addLast(12);
        list.addLast(13);
        list.addLast(14);
        list.addLast(15);
        list.addLast(16);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(14));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(16));
        assertThat(it.hasNext(), is(false));
    }
}

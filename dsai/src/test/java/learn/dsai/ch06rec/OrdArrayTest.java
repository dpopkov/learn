package learn.dsai.ch06rec;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class OrdArrayTest {

    @Test
    public void testInsert() {
        OrdArray a = new OrdArray(3);
        a.insert(33);
        assertThat(a.toString(), is("[33]"));
        a.insert(11);
        assertThat(a.toString(), is("[11, 33]"));
        a.insert(22);
        assertThat(a.toString(), is("[11, 22, 33]"));
    }

    @Test
    public void testIndexOf() {
        OrdArray a = new OrdArray(3);
        a.insert(11);
        a.insert(22);
        a.insert(33);
        assertThat(a.indexOf(10), is(-1));   // -pos - 1
        assertThat(a.indexOf(11), is(0));
        assertThat(a.indexOf(12), is(-2));
        assertThat(a.indexOf(22), is(1));
        assertThat(a.indexOf(23), is(-3));
        assertThat(a.indexOf(33), is(2));
        assertThat(a.indexOf(44), is(-4));
    }
}
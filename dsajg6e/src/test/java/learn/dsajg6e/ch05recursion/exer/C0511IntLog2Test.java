package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0511IntLog2.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0511IntLog2Test {
    @Test
    public void testLog2() {
        assertThat(log2Rec(1), is(0));
        assertThat(log2Rec(2), is(1));
        assertThat(log2Rec(4), is(2));
        assertThat(log2Rec(7), is(2));
        assertThat(log2Rec(8), is(3));
    }

    @Test
    public void testLog2NonRec() {
        assertThat(log2NonRec(1), is(0));
        assertThat(log2NonRec(2), is(1));
        assertThat(log2NonRec(4), is(2));
        assertThat(log2NonRec(7), is(2));
        assertThat(log2NonRec(8), is(3));
    }
}

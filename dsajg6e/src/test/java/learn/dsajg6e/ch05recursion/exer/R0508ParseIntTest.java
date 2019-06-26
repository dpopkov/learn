package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class R0508ParseIntTest {

    @Test
    public void testParseInt() {
        assertThat(R0508ParseInt.parseIntFrontToBack("1"), is(1));
        assertThat(R0508ParseInt.parseIntFrontToBack("10"), is(10));
        assertThat(R0508ParseInt.parseIntFrontToBack("123"), is(123));
        assertThat(R0508ParseInt.parseIntFrontToBack("2048"), is(2048));
    }

    @Test
    public void testParseInt2() {
        assertThat(R0508ParseInt.parseIntBackToFront("1"), is(1));
        assertThat(R0508ParseInt.parseIntBackToFront("10"), is(10));
        assertThat(R0508ParseInt.parseIntBackToFront("123"), is(123));
        assertThat(R0508ParseInt.parseIntBackToFront("2048"), is(2048));
    }
}

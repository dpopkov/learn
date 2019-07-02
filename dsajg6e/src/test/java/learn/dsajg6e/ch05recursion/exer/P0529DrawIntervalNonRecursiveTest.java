package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.P0529DrawIntervalNonRecursive.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0529DrawIntervalNonRecursiveTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testDrawInterval() {
        String s, expected;
        s = drawInterval(1);
        expected = "-" + NL;
        assertThat(s, is(expected));
        s = drawInterval(2);
        expected = String.join(NL, "-", "--", "-") + NL;
        assertThat(s, is(expected));
        s = drawInterval(3);
        expected = String.join(NL, "-", "--", "-", "---", "-", "--", "-") + NL;
        assertThat(s, is(expected));
    }
}

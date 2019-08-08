package learn.dsajg6e.tools;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CharDisplayTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void whenAddToLeftTopThenContainsAdded() {
        CharDisplay display = new CharDisplay(2);
        display.add('a', 0, 0);
        assertThat(display.toString(), is(" a" + NL));
    }

    @Test
    public void whenAddToRightTopThenContainsAdded() {
        CharDisplay display = new CharDisplay(2);
        display.add('a', 0, 0);
        display.add('b', 2, 0);
        assertThat(display.toString(), is(" a   b" + NL));
    }

    @Test
    public void whenAddToSecondLineThenContainsNewLine() {
        CharDisplay display = new CharDisplay(2);
        display.add('a', 0, 0);
        display.add('b', 0, 1);
        assertThat(display.toString(), is(" a" + NL + " b" + NL));
    }

    @Test
    public void whenAddBeforeLastAddedThenInsertsElementToExistingLine() {
        CharDisplay display = new CharDisplay(2);
        display.add('a', 0, 0);
        display.add('b', 1, 1);
        display.add('c', 2, 0);
        display.add('d', 4, 0);
        display.add('e', 0, 1);
        String expected =
                " a   c   d" + NL
                + " e b" + NL;
        assertThat(display.toString(), is(expected));
    }
}

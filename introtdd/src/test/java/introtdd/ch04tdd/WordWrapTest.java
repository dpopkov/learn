package introtdd.ch04tdd;

import org.junit.Test;

import static introtdd.ch04tdd.WordWrap.NL;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class WordWrapTest {
    private static final int LINE_LENGTH = 5;

    @Test
    public void lineShouldWrapIfOverLineLength() {
        String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        assertThat(result, is("The S" + NL + "leepy"));
    }

    @Test
    public void shortLinesShouldNotWrap() {
        String result = WordWrap.wrap("The", LINE_LENGTH);
        assertThat(result, is("The"));
    }

    @Test
    public void longerLineShouldWrapTwice() {
        String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
        assertThat(result, is("The S" + NL + "leepy" + NL + " Brow"));
    }

    @Test
    public void evenLongerLineShouldWrapThrice() {
        String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        assertThat(result, is("The S" + NL + "leepy" + NL + " Brow" + NL + "n Fox"));
    }

    @Test
    public void longLinesDontHaveToBeMultipleOfLineLength() {
        String result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
        assertThat(result, is("The S" + NL + "leepy" + NL + " Brow" + NL + "n Fox" + NL + "."));
    }
}

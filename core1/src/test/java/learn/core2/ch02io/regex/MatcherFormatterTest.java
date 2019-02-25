package learn.core2.ch02io.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MatcherFormatterTest {
    private final MatcherFormatter formatter = new MatcherFormatter();

    @Test
    public void whenFormatWithoutGroupsThenText() {
        String input = "abc";
        Matcher matcher = Pattern.compile("[a-c]{3}").matcher(input);
        assertThat(formatter.format(matcher, input), is("abc"));
    }

    @Test
    public void whenFormatWithGroupThenTextInParentheses() {
        String input = "a12";
        Matcher matcher = Pattern.compile("([a-c](\\d+))").matcher(input);
        assertThat(formatter.format(matcher, input), is("(a(12))"));
    }

    @Test
    public void whenFormatWithEmptyGroupThenEmptyParentheses() {
        String input = "a";
        Matcher matcher = Pattern.compile("(\\d?)([a-c])").matcher(input);
        assertThat(formatter.format(matcher, input), is("()(a)"));
    }
}
package learn.core2.ch02io.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MatchedFormatterTest {

    @Test
    public void testFormatInGroups() {
        String input = "11:59am";
        String patternStr = "(([1-9]|1[0-2]):([0-5][0-9]))[ap]m";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        assertThat(matcher.matches(), is(true));
        MatchedFormatter formatter = new MatchedFormatter(matcher);
        String expected = "((11):(59))am";
        String result = formatter.formatInGroups(input);
        assertThat(result, is(expected));
    }
}

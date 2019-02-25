package learn.core2.ch02io.regex;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RegexDemoTest {
    private static final String NL = System.lineSeparator();

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private PrintStream saved;

    @Before
    public void setup() {
        saved = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void testMain() {
        String input = ""
                + "([a-c]+)(\\d+)" + NL
                + "abc123" + NL
                + NL;
        ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inStream);
        RegexDemo.main(null);
        System.setOut(saved);
        assertThat(buffer.toString(), Is.is(""
                + "Enter pattern: "
                + "Enter string to match: "
                + "(abc)(123)" + NL
                + "Enter string to match: "));
    }
}

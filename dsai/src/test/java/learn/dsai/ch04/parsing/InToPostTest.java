package learn.dsai.ch04.parsing;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InToPostTest {

    @Test
    public void testTranslate() {
        testCase("2+3", "23+");
        testCase("2*3", "23*");
        testCase("(2-3)", "23-");
        testCase("4*(2-3)", "423-*");
        testCase("A*(B+C)-D/(E+F)", "ABC+*DEF+/-");
    }

    private void testCase(String infix, String expectedPostfix) {
        InToPost i2p = new InToPost(infix);
        String result = i2p.translate();
        String message = String.format("%s failed, result is %s", infix, result);
        assertThat(message, result, is(expectedPostfix));
    }
}

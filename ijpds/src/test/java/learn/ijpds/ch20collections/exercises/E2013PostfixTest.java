package learn.ijpds.ch20collections.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E2013PostfixTest {

    @Test
    public void when2Plus2Then4() {
        E2013Postfix postfix = new E2013Postfix();
        int result = postfix.evaluate("2 2 +");
        assertThat(result, is(4));
    }

    @Test
    public void when2Plus2Times3Divide6Then2() {
        E2013Postfix postfix = new E2013Postfix();
        int result = postfix.evaluate("2 2 + 3 * 6 /");
        assertThat(result, is(2));
    }
}

package learn.ijpds.ch20collections.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class E2014InfixTest {

    @Test
    public void when2Plus2() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("2 + 2");
        assertThat(postfix, is("2 2 +"));
    }

    @Test
    public void when2Plus2Plus2() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("2 + 2 + 2");
        assertThat(postfix, is("2 2 + 2 +"));
    }

    @Test
    public void when2Minus2Plus2() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("2 - 2 + 2");
        assertThat(postfix, is("2 2 - 2 +"));
    }

    @Test
    public void when11Minus2Times4() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("11 - 2 * 4");
        assertThat(postfix, is("11 2 4 * -"));
    }

    @Test
    public void when2Plus2Times3Divide4() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("2 + 2 * 3 / 4");
        assertThat(postfix, is("2 2 3 * 4 / +"));
    }

    @Test
    public void testPlusMultiplyMinus() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("3 + 2 * 7 - 5");
        assertThat(postfix, is("3 2 7 * + 5 -"));
    }

    @Test
    public void testLongExpression() {
        E2014Infix infix = new E2014Infix();
        String postfix = infix.toPostfix("9 / 3 + 2 * 7 / 3 - 5 * 3 + 2 - 4");
        assertThat(postfix, is("9 3 / 2 7 * 3 / + 5 3 * - 2 + 4 -"));
    }
}

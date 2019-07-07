package learn.dsajg6e.ch06stacks.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0619PostfixTest {

    @Test
    public void when23PlusThen5() {
        int rst = new C0619Postfix().evaluate("2 3 +");
        assertThat(rst, is(5));
    }

    @Test
    public void when74MinusThen3() {
        int rst = new C0619Postfix().evaluate("7 4 -");
        assertThat(rst, is(3));
    }

    @Test
    public void canEvaluateLongExpression() {
        int rst = new C0619Postfix().evaluate("5 2 + 8 3 - * 4 /");
        assertThat(rst, is(8));
    }
}

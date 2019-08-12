package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0859InfixToPostfixTest {

    @Test
    public void testInfixToPostfix() {
        C0859InfixToPostfix converter = new C0859InfixToPostfix();
        String result = converter.infixToPostfix("2 + 3");
        assertThat(result, is("2 3 +"));
        result = converter.infixToPostfix("3 * 4");
        assertThat(result, is("3 4 *"));
        result = converter.infixToPostfix("3 * 4 - 5");
        assertThat(result, is("3 4 * 5 -"));
    }

    @Test
    public void testInfixToPostfixWithParentheses() {
        C0859InfixToPostfix converter = new C0859InfixToPostfix();
        String result = converter.infixToPostfix("( 2 + 3 )");
        assertThat(result, is("2 3 +"));

        result = converter.infixToPostfix("( 3 * 4 ) - 5");
        assertThat(result, is("3 4 * 5 -"));

        result = converter.infixToPostfix("3 * ( 4 - 5 )");
        assertThat(result, is("3 4 5 - *"));

        result = converter.infixToPostfix("( 3 + ( 7 - 2 ) )");
        assertThat(result, is("3 7 2 - +"));

        result = converter.infixToPostfix("( 3 + ( 7 - 2 ) ) * ( 4 - 5 )");
        assertThat(result, is("3 7 2 - + 4 5 - *"));
    }
}

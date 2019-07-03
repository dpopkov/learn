package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static learn.dsajg6e.ch06stacks.MatchingParentheses.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MatchingParenthesesTest {

    @Test
    public void testIsMatched() {
        assertThat(isMatched("()"), is(true));
        assertThat(isMatched("[()"), is(false));
        assertThat(isMatched("[()}"), is(false));
        assertThat(isMatched("()}"), is(false));
        assertThat(isMatched("[{(+)}]"), is(true));
    }
}

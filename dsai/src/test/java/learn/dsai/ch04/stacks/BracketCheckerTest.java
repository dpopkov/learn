package learn.dsai.ch04.stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BracketCheckerTest {

    @Test
    public void whenEmptyThenIsBalancedReturnsTrue() {
        BracketChecker checker = new BracketChecker("");
        assertThat(checker.isBalanced(), is(true));
    }

    @Test
    public void whenNotClosedThenIsBalancedReturnsFalse() {
        BracketChecker checker = new BracketChecker("(");
        assertThat(checker.isBalanced(), is(false));
        assertThat(checker.getError(), is("no closing for ("));
    }

    @Test
    public void whenClosedThenIsBalancedReturnsTrue() {
        BracketChecker checker = new BracketChecker("(a)");
        assertThat(checker.isBalanced(), is(true));
    }

    @Test
    public void whenNotMatchedThenIsBalancedReturnsFalse() {
        BracketChecker checker = new BracketChecker("(a]");
        assertThat(checker.isBalanced(), is(false));
        assertThat(checker.getError(), is("no match for ]"));
    }

    @Test
    public void whenNoOpeningThenIsBalancedReturnsFalse() {
        BracketChecker checker = new BracketChecker("(a)}");
        assertThat(checker.isBalanced(), is(false));
        assertThat(checker.getError(), is("no opening for }"));
    }

    @Test
    public void compareResultsOfCheckedAndIsBalanced() {
        String[] data = {
                "a[d]",
                "a{b[c]d}e",
                "a{b(c]d}e",
                "a[b{c}d]e}",
                "a{b(c)"
        };
        boolean[] expected = {
                true,
                true,
                false,
                false,
                false
        };
        for (int i = 0; i < data.length; i++) {
            BracketChecker checker = new BracketChecker(data[i]);
            assertThat(checker.isBalanced(), is(expected[i]));
            assertThat(checker.check(), is(expected[i]));
        }
    }
}

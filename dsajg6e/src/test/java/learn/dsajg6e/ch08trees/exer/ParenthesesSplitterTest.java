package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ParenthesesSplitterTest {

    @Test
    public void whenNoParenthesesThenAsIs() {
        ParenthesesSplitter splitter = new ParenthesesSplitter();
        List<String> tokens = splitter.split("token");
        assertThat(tokens, is(List.of("token")));
    }

    @Test
    public void whenParenthesesThenAsIs() {
        ParenthesesSplitter splitter = new ParenthesesSplitter();
        List<String> tokens = splitter.split("(ab)");
        assertThat(tokens, is(List.of("(ab)")));
    }

    @Test
    public void whenTwoParenthesisedThenTwoWords() {
        ParenthesesSplitter splitter = new ParenthesesSplitter();
        List<String> tokens = splitter.split("(abc)(efg)");
        assertThat(tokens, is(List.of("(abc)", "(efg)")));
    }

    @Test
    public void whenThreeParenthesisedThenThreeWords() {
        ParenthesesSplitter splitter = new ParenthesesSplitter();
        List<String> tokens = splitter.split("(ab)(ef)(gh)");
        assertThat(tokens, is(List.of("(ab)", "(ef)", "(gh)")));
    }

    @Test
    public void whenThreeParenthesisedNestedThenTwoTokens() {
        ParenthesesSplitter splitter = new ParenthesesSplitter();
        List<String> tokens = splitter.split("((ab)(ef))(gh)");
        assertThat(tokens, is(List.of("((ab)(ef))", "(gh)")));
    }
}

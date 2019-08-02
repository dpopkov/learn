package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import learn.dsajg6e.ch08trees.Tree;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class R0824ParenthesesSetterTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void canParenthesize() throws IOException {
        Tree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15);
        String expected = "20 (10 (5, 15), 30)";
        StringBuilder builder = new StringBuilder();
        R0824ParenthesesSetter setter = new R0824ParenthesesSetter();
        setter.parenthesize(tree, tree.root(), builder);
        String result = builder.toString();
        assertThat(result, is(expected));
    }

    @Test
    public void canParenthesizeWithWidthLimit() throws IOException {
        Tree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15);
        String expected = "20 (10 (5, 15)," + NL + "30)";
        StringBuilder builder = new StringBuilder();
        R0824ParenthesesSetter setter = new R0824ParenthesesSetter();
        setter.parenthesize(tree, tree.root(), builder, 15);
        String result = builder.toString();
        assertThat(result, is(expected));
    }
}

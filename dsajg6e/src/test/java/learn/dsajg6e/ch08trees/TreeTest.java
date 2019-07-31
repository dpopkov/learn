package learn.dsajg6e.ch08trees;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void canParenthesize() throws IOException {
        Tree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15);
        String expected = "20 (10 (5, 15), 30)";
        StringBuilder sb = new StringBuilder();
        Tree.parenthesize(tree, tree.root(), sb);
        String result = sb.toString();
        assertThat(result, is(expected));
    }
}

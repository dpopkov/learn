package learn.dsai.ch08trees.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0804ExpressionTreeTest {

    @Test
    public void testMakeTree() {
        P0804ExpressionTree tree = new P0804ExpressionTree("32+85-*2+");
        NodeChar root = tree.getRoot();
        assertThat(root.character, is('+'));
        assertThat(root.left.character, is('*'));
        assertThat(root.right.character, is('2'));
        assertThat(root.left.left.character, is('+'));
        assertThat(root.left.right.character, is('-'));
        assertThat(root.left.left.left.character, is('3'));
        assertThat(root.left.left.right.character, is('2'));
        assertThat(root.left.right.left.character, is('8'));
        assertThat(root.left.right.right.character, is('5'));
    }
}
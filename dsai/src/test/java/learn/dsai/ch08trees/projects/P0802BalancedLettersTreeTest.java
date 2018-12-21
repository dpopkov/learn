package learn.dsai.ch08trees.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0802BalancedLettersTreeTest {

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testMakeTree() {
        P0802BalancedLettersTree tree = new P0802BalancedLettersTree("not_used");
        NodeChar[] forest = tree.makeForest("abcd");
        tree.makeTree(forest);
        NodeChar root = forest[0];
        assertThat(root.character, is('+'));
        assertThat(root.left.character, is('+'));
        assertThat(root.right.character, is('+'));
        assertThat(root.left.left.character, is('a'));
        assertThat(root.left.right.character, is('b'));
        assertThat(root.right.left.character, is('c'));
        assertThat(root.right.right.character, is('d'));
    }
}
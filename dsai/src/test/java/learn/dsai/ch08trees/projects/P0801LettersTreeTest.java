package learn.dsai.ch08trees.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0801LettersTreeTest {

    @Test
    public void testMakeTree() {
        P0801LettersTree tree = new P0801LettersTree("not used");
        NodeChar[] forest = tree.makeForest("abc");
        assertNotNull(forest);
        tree.makeTree(forest);
        NodeChar root = forest[0];
        assertThat(root.character, is('+'));
        assertThat(root.left.character, is('+'));
        assertThat(root.right.character, is('c'));
        assertThat(root.left.left.character, is('a'));
        assertThat(root.left.right.character, is('b'));
    }
}
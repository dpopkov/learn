package learn.dsai.ch08trees.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0801LettersTreeTest {

    @Test
    public void testMakeForest() {
        NodeChar[] forest = P0801LettersTree.makeForest("abc");
        assertNotNull(forest);
        assertThat(forest.length, is(3));
        assertThat(forest[0].character, is('a'));
        assertThat(forest[1].character, is('b'));
        assertThat(forest[2].character, is('c'));
    }

    @Test
    public void testMakeTree() {
        NodeChar[] forest = P0801LettersTree.makeForest("abc");
        assertNotNull(forest);
        P0801LettersTree.makeTree(forest);
        NodeChar root = forest[0];
        assertThat(root.character, is('+'));
        assertThat(root.left.character, is('+'));
        assertThat(root.right.character, is('c'));
        assertThat(root.left.left.character, is('a'));
        assertThat(root.left.right.character, is('b'));
    }
}
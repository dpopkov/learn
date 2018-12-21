package learn.dsai.ch08trees.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0803CompleteLettersTreeTest {

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testMakeTree() {
        P0803CompleteLettersTree tree = new P0803CompleteLettersTree("not_used");
        NodeChar[] forest = tree.makeForest("abcde");
        tree.makeTree(forest);
        NodeChar root = forest[0];
        assertThat(root.character, is('a'));
        assertThat(root.left.character, is('b'));
        assertThat(root.right.character, is('c'));
        assertThat(root.left.left.character, is('d'));
        assertThat(root.left.right.character, is('e'));
    }
}

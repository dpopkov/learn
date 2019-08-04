package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0836PruneSubtreeTest {

    @Test
    public void testPruneSubtree() {
        C0836PruneSubtree<Integer> tree = new C0836PruneSubtree<>();
        LinkedBinaryTree.populate(tree, 20, 10, 30, 5, 15);
        Position<Integer> root = tree.root();
        assertThat(tree.size(), is(5));
        int removed = tree.pruneSubtree(tree.left(root));
        assertThat(removed, is(3));
        assertThat(tree.size(), is(2));
        assertNull(tree.left(root));
    }
}

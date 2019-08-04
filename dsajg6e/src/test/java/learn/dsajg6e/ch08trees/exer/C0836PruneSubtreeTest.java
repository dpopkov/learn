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

    /* C-8.37 - Swap */
    @Test
    public void testSwapAdjacentNodes() {
        C0836PruneSubtree<Integer> tree = new C0836PruneSubtree<>();
        LinkedBinaryTree.populate(tree, 20, 10, 30, 5, 15, 25, 35);
        Position<Integer> root = tree.root();
        var p = tree.left(root);
        var q = tree.right(root);
        tree.swap(p, q);
        assertThat(tree.left(root).getElement(), is(30));
        Position<Integer> right = tree.right(root);
        assertThat(right.getElement(), is(10));
        assertThat(tree.firstChild(right), is(5));
    }

    @Test
    public void testSwapNonAdjacentNodes() {
        C0836PruneSubtree<Integer> tree = new C0836PruneSubtree<>();
        LinkedBinaryTree.populate(tree, 20, 10, 30, 5, 15, 25, 35);
        Position<Integer> root = tree.root();
        var left = tree.left(root);
        var right = tree.right(root);
        var p = tree.left(left);
        var q = tree.right(right);
        tree.swap(p, q);
        assertThat(tree.left(left).getElement(), is(35));
        assertThat(tree.right(right).getElement(), is(5));
    }
}

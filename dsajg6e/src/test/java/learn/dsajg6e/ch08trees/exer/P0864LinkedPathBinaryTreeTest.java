package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0864LinkedPathBinaryTreeTest {

    @Test
    public void canAddElements() {
        P0864LinkedPathBinaryTree<Integer> tree = new P0864LinkedPathBinaryTree<>();
        Position<Integer> root = tree.addRoot(20);
        assertThat(tree.size(), is(1));
        assertThat(root.getElement(), is(20));
        assertThat(tree.root().getElement(), is(20));
        var left = tree.addLeft(root, 10);
        assertThat(left.getElement(), is(10));
        assertThat(tree.size(), is(2));
        assertThat(tree.left(root).getElement(), is(10));
        var right = tree.addRight(root, 30);
        assertThat(right.getElement(), is(30));
        assertThat(tree.size(), is(3));
        assertThat(tree.right(root).getElement(), is(30));
    }

    @Test
    public void canReturnParent() {
        P0864LinkedPathBinaryTree<Integer> tree = new P0864LinkedPathBinaryTree<>();
        Position<Integer> root = tree.addRoot(20);
        var left = tree.addLeft(root, 10);
        var parent = tree.parent(left);
        assertThat(parent.getElement(), is(20));
    }
}

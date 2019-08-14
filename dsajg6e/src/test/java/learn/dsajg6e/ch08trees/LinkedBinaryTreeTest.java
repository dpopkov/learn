package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LinkedBinaryTreeTest {

    @Test
    public void testAddRoot() {
        var tree = new LinkedBinaryTree<Integer>();
        var p10 = tree.addRoot(10);
        assertThat(tree.root().getElement(), is(10));
        assertThat(p10.getElement(), is(10));
        assertThat(tree.size(), is(1));
    }

    @Test
    public void testAddLeftRight() {
        var tree = new LinkedBinaryTree<Integer>();
        var p20 = tree.addRoot(20);
        var p10 = tree.addLeft(p20, 10);
        var p30 = tree.addRight(p20, 30);
        assertThat(p10.getElement(), is(10));
        assertThat(p30.getElement(), is(30));
        assertThat(tree.left(p20).getElement(), is(10));
        assertThat(tree.right(p20).getElement(), is(30));
        assertThat(tree.size(), is(3));
    }

    @Test
    public void testAttach() {
        var t1 = new LinkedBinaryTree<Integer>();
        t1.addRoot(10);
        var t2 = new LinkedBinaryTree<Integer>();
        t2.addRoot(30);
        var t = new LinkedBinaryTree<Integer>();
        var r = t.addRoot(20);
        t.attach(r, t1, t2);
        assertThat(t.size(), is(3));
        assertThat(t.left(r).getElement(), is(10));
        assertThat(t.right(r).getElement(), is(30));
    }

    @Test
    public void testRemove() {
        var tree = new LinkedBinaryTree<Integer>();
        var root = tree.addRoot(20);
        var p = tree.addRight(root, 30);
        assertThat(tree.isInternal(root), is(true));
        var v30 = tree.remove(p);
        assertThat(v30, is(30));
        assertThat(tree.isExternal(root), is(true));
    }

    @Test
    public void testSet() {
        var tree = new LinkedBinaryTree<Integer>();
        var root = tree.addRoot(20);
        assertThat(root.getElement(), is(20));
        var v20 = tree.set(root, 22);
        assertThat(v20, is(20));
        assertThat(root.getElement(), is(22));
    }

    @Test
    public void whenOfThenAddsElementsBreadthFirst() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, null, 15, 25, null);
        Position<Integer> root = tree.root();
        Position<Integer> left = tree.left(root);
        Position<Integer> right = tree.right(root);
        assertThat(root.getElement(), is(20));
        assertThat(left.getElement(), is(10));
        assertThat(right.getElement(), is(30));
        assertNull(tree.left(left).getElement());
        assertThat(tree.right(left).getElement(), is(15));
        assertThat(tree.left(right).getElement(), is(25));
        assertNull(tree.right(right).getElement());
        assertThat(tree.size(), is(7));
    }


    @Test
    public void whenPopulateTreeWithNullElementsThenNotAddsNulls() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.populate(tree, true, 20, null, 30, null, null, 25, 35);
        assertThat(tree.size(), is(4));
        var root = tree.root();
        assertThat(root.getElement(), is(20));
        Position<Integer> right = tree.right(root);
        assertThat(right.getElement(), is(30));
        assertThat(tree.left(right).getElement(), is(25));
        assertThat(tree.right(right).getElement(), is(35));
    }
}

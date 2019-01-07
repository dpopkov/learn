package learn.dsai.ch08trees2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class BSTreeTest {

    @Test
    public void whenFindInRootThenReturnsResult() {
        BSTree.Node<Integer> root = new BSTree.Node<>(20);
        BSTree<Integer> tree = new BSTree<>(root);
        Integer rst = tree.find(20);
        assertThat(rst, is(20));
    }

    @Test
    public void whenFindInLeftThenReturnsResult() {
        BSTree.Node<Integer> root = new BSTree.Node<>(20);
        root.left = new BSTree.Node<>(10);
        BSTree<Integer> tree = new BSTree<>(root);
        Integer rst = tree.find(10);
        assertThat(rst, is(10));
    }

    @Test
    public void whenFindInRightSubTreeThenReturnsResult() {
        BSTree.Node<Integer> root = new BSTree.Node<>(20);
        BSTree.Node<Integer> right = new BSTree.Node<>(30);
        right.left = new BSTree.Node<>(25);
        root.right = right;
        BSTree<Integer> tree = new BSTree<>(root);
        Integer rst = tree.find(25);
        assertThat(rst, is(25));
    }

    @Test
    public void whenInsertFirstValueThenTreeContainsTheValue() {
        var tree = new BSTree<Integer>();
        tree.insert(10);
        assertThat(tree.find(10), is(10));
    }

    @Test
    public void whenInsertSmallerValueThenTreeContainsTheValue() {
        var tree = new BSTree<Integer>();
        tree.insert(10, 5);
        assertThat(tree.find(5), is(5));
    }

    @Test
    public void whenInsertGreaterValueThenTreeContainsTheValue() {
        var tree = new BSTree<Integer>();
        tree.insert(10, 20, 15);
        assertThat(tree.find(15), is(15));
    }

    @Test
    public void whenInOrderThenIteratesAscendingElements() {
        var tree = new BSTree<Integer>();
        tree.insert(5, 2, 8, 1, 3, 6, 9);
        List<Integer> buffer = new ArrayList<>();
        tree.inOrder(buffer::add);
        assertThat(buffer, is(List.of(1, 2, 3, 5, 6, 8, 9)));
    }

    @Test
    public void whenMinimumThenReturnsTheLowerElement() {
        var tree = new BSTree<Integer>();
        tree.insert(5, 2, 8, 1, 3, 6, 9);
        assertThat(tree.minimum(), is(1));
    }

    @Test
    public void whenMaximumThenReturnsTheHighestElement() {
        var tree = new BSTree<Integer>();
        tree.insert(5, 2, 8, 1, 3, 9, 6);
        assertThat(tree.maximum(), is(9));
    }

    @Test
    public void whenDeleteLeafNodeThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(2, 1);
        assertNotNull(tree.find(1));
        boolean rst = tree.delete(1);
        assertThat(rst, is(true));
        assertNull(tree.find(1));
    }

    @Test
    public void whenDelete2ndLevelLeafNodeThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(4, 2, 1, 3);
        assertNotNull(tree.find(3));
        boolean rst = tree.delete(3);
        assertThat(rst, is(true));
        assertNull(tree.find(3));
    }

    @Test
    public void whenDeleteNonExistingLeafNodeThenFalse() {
        var tree = new BSTree<Integer>();
        tree.insert(4, 6, 5, 7);
        assertThat(tree.delete(8), is(false));
    }

    @Test
    public void whenDeleteLeafRootThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(3);
        assertThat(tree.find(3), is(3));
        assertThat(tree.delete(3), is(true));
        assertNull(tree.find(3));
    }

    @Test
    public void whenDeleteNodeWithOneLeftChildThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(1, 3, 2);
        assertThat(tree.find(3), is(3));
        assertThat(tree.delete(3), is(true));
        assertNull(tree.find(3));
    }

    @Test
    public void whenDeleteNodeWithOneRightChildThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(4, 3, 1, 2);
        assertThat(tree.find(1), is(1));
        assertThat(tree.delete(1), is(true));
        assertNull(tree.find(1));
    }

    @Test
    public void whenDeleteRootWithOneChildThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(3, 4);
        assertThat(tree.delete(3), is(true));
        assertNull(tree.find(3));
        assertThat(tree.find(4), is(4));
    }

    @Test
    public void whenDeleteNode1LevelBelowWith2SubNodesThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(20, 10, 5, 15);
        assertTreeContains(tree, 5, 10, 15, 20);
        assertThat(tree.delete(10), is(true));
        assertNull(tree.find(10));
        assertTreeContains(tree, 5, 15, 20);
    }

    @Test
    public void whenDeleteNode2LevelsBelowWith2SubNodesThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(40, 20, 10, 30, 5, 15, 25, 35, 26);
        assertTreeContains(tree, 40, 20, 10, 30, 5, 15, 25, 35, 26);
        assertThat(tree.toString(), is("[5, 10, 15, 20, 25, 26, 30, 35, 40]"));
        assertThat(tree.delete(20), is(true));
        assertNull(tree.find(20));
        assertTreeContains(tree, 40, 10, 30, 5, 15, 25, 35, 26);
        assertThat(tree.toString(), is("[5, 10, 15, 25, 26, 30, 35, 40]"));
    }

    @Test
    public void testToString() {
        var tree = new BSTree<Integer>();
        tree.insert(80, 40, 60, 50, 45, 55, 47);
        assertThat(tree.toString(), is("[40, 45, 47, 50, 55, 60, 80]"));
    }

    @Test
    public void whenDeleteRootWith2SubNodesThenDeleted() {
        var tree = new BSTree<Integer>();
        tree.insert(40, 20, 60);
        assertTreeContains(tree, 20, 40, 60);
        assertThat(tree.delete(40), is(true));
        assertNull(tree.find(40));
        assertTreeContains(tree, 20, 60);
    }

    private void assertTreeContains(BSTree<Integer> tree, Integer... values) {
        for (Integer value : values) {
            assertThat(tree.find(value), is(value));
        }
    }
}

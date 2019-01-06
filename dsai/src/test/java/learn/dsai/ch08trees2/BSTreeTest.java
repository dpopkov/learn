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
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(10);
        assertThat(tree.find(10), is(10));
    }

    @Test
    public void whenInsertSmallerValueThenTreeContainsTheValue() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(10);
        tree.insert(5);
        assertThat(tree.find(5), is(5));
    }

    @Test
    public void whenInsertGreaterValueThenTreeContainsTheValue() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        assertThat(tree.find(15), is(15));
    }

    @Test
    public void whenInOrderThenIteratesAscendingElements() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(5, 2, 8, 1, 3, 6, 9);
        List<Integer> buffer = new ArrayList<>();
        tree.inOrder(buffer::add);
        assertThat(buffer, is(List.of(1, 2, 3, 5, 6, 8, 9)));
    }

    @Test
    public void whenMinimumThenReturnsTheLowerElement() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(5, 2, 8, 1, 3, 6, 9);
        assertThat(tree.minimum(), is(1));
    }

    @Test
    public void whenMaximumThenReturnsTheHighestElement() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(5, 2, 8, 1, 3, 9, 6);
        assertThat(tree.maximum(), is(9));
    }

    @Test
    public void whenDeleteLeafNodeThenDeleted() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(2, 1);
        assertNotNull(tree.find(1));
        boolean rst = tree.delete(1);
        assertThat(rst, is(true));
        assertNull(tree.find(1));
    }

    @Test
    public void whenDelete2ndLevelLeafNodeThenDeleted() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(4, 2, 1, 3);
        assertNotNull(tree.find(3));
        boolean rst = tree.delete(3);
        assertThat(rst, is(true));
        assertNull(tree.find(3));
    }

    // TODO: Test return value false of method delete
    //TODO: Test delete leaf root
}

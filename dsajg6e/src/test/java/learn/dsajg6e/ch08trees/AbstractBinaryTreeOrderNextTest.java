package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Tests for methods:
 * preOrderNext(p),
 */
public class AbstractBinaryTreeOrderNextTest {

    @Test
    public void whenPreOrderNextAfterParentThenReturnLeft() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.preOrderNext(tree.root());
        assertThat(result.getElement(), is(10));
    }

    @Test
    public void whenPreOrderNextAfterLeftThenReturnRight() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.preOrderNext(tree.left(tree.root()));
        assertThat(result.getElement(), is(30));
    }

    @Test
    public void whenPreOrderNextAfterRightThenReturnNextParent() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15);
        Position<Integer> prev = tree.right(tree.left(tree.root()));
        Position<Integer> result = tree.preOrderNext(prev);
        assertThat(prev.getElement(), is(15));
        assertThat(result.getElement(), is(30));
    }

    @Test
    public void whenPreOrderNextThenReturnsSameElementsAsPreOrderIteration() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15, 25, 35, 2, 7);
        var it = tree.preOrder().iterator();
        assertThat(it.next().getElement(), is(20));
        var next = tree.root();
        while (it.hasNext()) {
            Integer elementIter = it.next().getElement();
            next = tree.preOrderNext(next);
            assertThat(elementIter.equals(next.getElement()), is(true));
        }
    }

    @Test
    public void whenPreOrderNextAfterLastRightThenReturnsNull() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.preOrderNext(tree.right(tree.root()));
        assertNull(result);
    }

    @Test
    public void whenInOrderAfterLeftThenReturnsParent() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.inOrderNext(tree.left(tree.root()));
        assertThat(result.getElement(), is(20));
    }

    @Test
    public void whenInOrderAfterParentThenReturnRight() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.inOrderNext(tree.root());
        assertThat(result.getElement(), is(30));
    }

    @Test
    public void whenInOrderAfterRightThenReturnNextParent() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15);
        Position<Integer> left = tree.left(tree.root());
        Position<Integer> result = tree.inOrderNext(tree.right(left));
        assertThat(result.getElement(), is(20));
    }

    @Test
    public void whenInOrderAfterParentWithRightSubTreeThenReturnMostLeftSubNode() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15, 25, 35);
        var root = tree.root();
        var result = tree.inOrderNext(root);
        assertThat(result.getElement(), is(25));
    }

    @Test
    public void whenInOrderThenReturnSameElementsAtInOrderIteration() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15, 25, 35);
        var next = tree.left(tree.left(tree.root()));
        for (Position<Integer> posIt : tree.inOrder()) {
            Integer elementIt = posIt.getElement();
            Integer element = next.getElement();
            assertThat(elementIt, is(element));
            next = tree.inOrderNext(next);
        }
    }

    @Test
    public void whenPostOrderAfterLeftThenReturnRight() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.postOrderNext(tree.left(tree.root()));
        assertThat(result.getElement(), is(30));
    }

    @Test
    public void whenPostOrderAfterRightThenReturnParent() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30);
        Position<Integer> result = tree.postOrderNext(tree.right(tree.root()));
        assertThat(result.getElement(), is(20));
    }

    @Test
    public void whenPostOrderNextThenReturnsSameElementsAsPostOrderIteration() {
        LinkedBinaryTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15, 25, 35);
        Position<Integer> p = tree.left(tree.left(tree.root()));
        for (Position<Integer> postIt : tree.postOrder()) {
            Integer expected = postIt.getElement();
            Integer actual = p.getElement();
            assertThat(actual, is(expected));
            p = tree.postOrderNext(p);
        }
    }
}

package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0857DiameterOfBinaryTreeTest {
    @Test
    public void canFindMostLeftPosition() {
        C0857DiameterOfBinaryTree<Integer> tree = new C0857DiameterOfBinaryTree<>();
        LinkedBinaryTree.populate(tree, 40, 20, 60);
        Position<Integer> min = tree.min();
        assertThat(min.getElement(), is(20));
    }

    @Test
    public void canFindMostRightPosition() {
        C0857DiameterOfBinaryTree<Integer> tree = new C0857DiameterOfBinaryTree<>();
        LinkedBinaryTree.populate(tree, 40, 20, 60);
        Position<Integer> max = tree.max();
        assertThat(max.getElement(), is(60));
    }

    @Test
    public void testDistance() {
        C0857DiameterOfBinaryTree<Integer> tree = new C0857DiameterOfBinaryTree<>();
        LinkedBinaryTree.populate(tree, 40, 20, 60);
        var min = tree.min();
        var max = tree.max();
        int result = tree.distance(min, max);
        assertThat(result, is(2));
    }

    @Test
    public void testDiameter() {
        C0857DiameterOfBinaryTree<Integer> tree = new C0857DiameterOfBinaryTree<>();
        LinkedBinaryTree.populate(tree, 40, 20, 60, 10, 30, 50, 70);
        int result = tree.diameter();
        assertThat(result, is(4));
    }
}

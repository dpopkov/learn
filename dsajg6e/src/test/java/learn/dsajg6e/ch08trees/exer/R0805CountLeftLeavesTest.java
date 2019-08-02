package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.BinaryTree;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class R0805CountLeftLeavesTest {
    @Test
    public void testCountLeftLeaves() {
        BinaryTree<Integer> tree = LinkedBinaryTree.of(1, 2, 3, 4, 5, 6, 7, null, null, 10, null, 12, null, 14, null);
        assertThat(tree.size(), is(15));
        int result = new R0805CountLeftLeaves().countLeftLeaves(tree);
        assertThat(result, is(4));
    }
}

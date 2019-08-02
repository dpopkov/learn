package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class R0816ArrayBinaryTreeTest {

    @Test
    public void whenAddThenElementsBuildBinaryTree() {
        R0816ArrayBinaryTree<Integer> tree = new R0816ArrayBinaryTree<>(8);
        tree.add(0, 20);
        tree.add(1, 10);
        tree.add(2, 30);
        assertThat(tree.size(), is(3));
        assertThat(tree.root(), is(20));
        assertThat(tree.left(0), is(10));
        assertThat(tree.right(0), is(30));
        assertThat(tree.parent(1), is(20));
        assertThat(tree.parent(2), is(20));
        assertThat(tree.isExternal(1), is(true));
        assertThat(tree.isExternal(2), is(true));
        assertThat(tree.isExternal(0), is(false));
        assertThat(tree.toString(), is("[20, 10, 30]"));
    }
}

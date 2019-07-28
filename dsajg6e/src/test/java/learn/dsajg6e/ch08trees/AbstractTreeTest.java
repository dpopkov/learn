package learn.dsajg6e.ch08trees;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AbstractTreeTest {

    @Test
    public void iteratorCanIterate() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var p20 = tree.addRoot(20);
        tree.addLeft(p20, 10);
        tree.addRight(p20, 30);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void canTraversePostOrder() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var p20 = tree.addRoot(20);
        tree.addLeft(p20, 10);
        tree.addRight(p20, 30);
        var it = tree.postOrder().iterator();
        assertThat(it.next().getElement(), is(10));
        assertThat(it.next().getElement(), is(30));
        assertThat(it.next().getElement(), is(20));
        assertThat(it.hasNext(), is(false));
    }
}

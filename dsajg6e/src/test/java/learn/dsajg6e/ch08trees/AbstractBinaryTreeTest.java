package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AbstractBinaryTreeTest {

    @Test
    public void whenPositionsThenReturnsPositionsInOrder() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var p20 = tree.addRoot(20);
        tree.addLeft(p20, 10);
        tree.addRight(p20, 30);
        Iterator<Position<Integer>> it = tree.positions().iterator();
        assertThat(it.next().getElement(), is(10));
        assertThat(it.next().getElement(), is(20));
        assertThat(it.next().getElement(), is(30));
        assertThat(it.hasNext(), is(false));
    }
}

package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0846NonRecursiveInOrderTest {

    @Test
    public void whenNonRecursiveInOrderThenReturnsSameElementsAsRecursiveInOrder() {
        C0846NonRecursiveInOrder<Integer> tree = new C0846NonRecursiveInOrder<>();
        LinkedBinaryTree.populate(tree, 20, 10, 30, 5, 15, 25, 35);
        Iterator<Position<Integer>> treeIt = tree.inOrderNonRec().iterator();
        for (Position<Integer> position : tree.inOrder()) {
            assertThat(treeIt.hasNext(), is(true));
            Integer result = treeIt.next().getElement();
            Integer expected = position.getElement();
            assertThat(result, is(expected));
        }
        assertThat(treeIt.hasNext(), is(false));
    }
}

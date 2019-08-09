package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NTreeTest {

    @Test
    public void canAddRoot() {
        NTree<Integer> tree = new NTree<>();
        var root = tree.addRoot(10);
        assertThat(root.getElement(), is(10));
        assertThat(tree.size(), is(1));
        assertThat(tree.root().getElement(), is(10));
    }

    @Test
    public void canAddElements() {
        NTree<Integer> tree = new NTree<>();
        var root = tree.addRoot(10);
        tree.add(root, 20);
        tree.add(root, 30);
        tree.add(root, 40);
        assertThat(tree.size(), is(4));
        assertThat(tree.numChildren(root), is(3));
        var it = tree.children(root).iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getElement(), is(20));
        assertThat(it.next().getElement(), is(30));
        assertThat(it.next().getElement(), is(40));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void canSetElement() {
        NTree<Integer> tree = new NTree<>();
        var root = tree.addRoot(10);
        var p20 = tree.add(root, 20);
        var p22 = tree.set(p20, 22);
        assertThat(p22.getElement(), is(22));
        assertThat(tree.children(tree.root()).iterator().next().getElement(), is(22));
    }

    @Test
    public void canIterateInOrder() {
        NTree<Integer> tree = new NTree<>();
        var root = tree.addRoot(40);
        var p20 = tree.add(root, 20);
        var p60 = tree.add(root, 60);
        tree.add(p20, 10);
        tree.add(p20, 25);
        tree.add(p20, 30);
        tree.add(p60, 50);
        tree.add(p60, 55);
        tree.add(p60, 70);
        tree.add(p60, 75);
        Iterator<Integer> expIt = List.of(10, 20, 25, 30, 40, 50, 55, 60, 70, 75).iterator();
        Iterable<Position<Integer>> positions = tree.inOrder();
        for (Position<Integer> p : positions) {
            Integer expected = expIt.next();
            Integer actual = p.getElement();
            assertThat(actual, is(expected));
        }
        assertThat(expIt.hasNext(), is(false));
    }
}

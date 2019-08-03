package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

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
        tree.set(p20, 22);
        assertThat(tree.children(tree.root()).iterator().next().getElement(), is(22));
    }
}

package learn.dsai.ch09rbtrees;

import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class RbTreeTest {

    @Test
    public void whenAddFirstElementThenContainsIt() {
        RbTree<Integer> tree = new RbTree<>();
        tree.add(10);
        assertThat(tree.toString(), is("" +
                "R:10" + NL
        ));
    }

    @Test
    public void whenFlipColorThenColorsChange() {
        RbNode<Integer> root = new RbNode<>(10, false);
        root.left = new RbNode<>(5, true);
        root.right = new RbNode<>(15, true);
        RbTree<Integer> tree = new RbTree<>(root);
        assertThat(root.isRed(), is(true));
        assertThat(root.left.isBlack(), is(true));
        assertThat(root.right.isBlack(), is(true));
        tree.flipColor(root);
        assertThat(root.isRed(), is(false));
        assertThat(root.left.isBlack(), is(false));
        assertThat(root.right.isBlack(), is(false));
        tree.flipColor(root);
        assertThat(root.isRed(), is(false));
        assertThat(root.left.isBlack(), is(true));
        assertThat(root.right.isBlack(), is(true));
        tree.flipColor(root);
        assertThat(root.isRed(), is(false));
        assertThat(root.left.isBlack(), is(false));
        assertThat(root.right.isBlack(), is(false));
    }
}

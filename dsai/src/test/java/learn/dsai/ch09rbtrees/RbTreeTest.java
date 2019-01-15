package learn.dsai.ch09rbtrees;

import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class RbTreeTest {
    private RbNode<Integer> root;
    private RbTree<Integer> tree;

    @Test
    public void whenAddFirstElementThenContainsIt() {
        tree = new RbTree<>();
        tree.add(10);
        assertThat(tree.toString(), is("" +
                "R:10" + NL
        ));
    }

    @Test
    public void whenFlipColorThenColorsChange() {
        root = new RbNode<>(10, false);
        root.left = new RbNode<>(5, true);
        root.right = new RbNode<>(15, true);
        tree = new RbTree<>(root);
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

    @Test
    public void whenRootIsNotBlackThenNotRedBlackCorrect() {
        root = new RbNode<>(10, false);
        tree = new RbTree<>(root);
        assertFalse(tree.isRedBlackCorrect());
    }

    @Test
    public void whenRootIsBlackThenRedBlackCorrect() {
        root = new RbNode<>(10, true);
        tree = new RbTree<>(root);
        assertTrue(tree.isRedBlackCorrect(root));
    }

    @Test
    public void whenNodeRedChildrenRedThenNotRedBlackCorrect() {
        root = new RbNode<>(10, false);
        root.left = new RbNode<>(5, false);
        root.right = new RbNode<>(15, false);
        tree = new RbTree<>(root);
        assertFalse(tree.isRedBlackCorrect(root));
    }

    @Test
    public void whenNodeRedChildrenBlackThenRedBlackCorrect() {
        root = new RbNode<>(10, false);
        root.left = new RbNode<>(5, true);
        root.right = new RbNode<>(15, true);
        tree = new RbTree<>(root);
        assertTrue(tree.isRedBlackCorrect(root));
    }

    @Test
    public void whenAttachingNodesThenRedBlackCorrect() {
        root = new RbNode<>(50, true);
        tree = new RbTree<>(root);
        assertTrue(tree.isRedBlackCorrect());
        root.left = new RbNode<>(25);
        assertTrue(tree.isRedBlackCorrect());
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    ----" + NL
        ));
        root.right = new RbNode<>(75);
        assertTrue(tree.isRedBlackCorrect());
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    R:75" + NL
        ));
    }

    @Test
    public void whenAttachRedSubNodeThenRedBlackNotCorrect() {
        standardThreeNodesInit();
        assertTrue(tree.isRedBlackCorrect());
        root.left.left = new RbNode<>(12);
        assertFalse(tree.isRedBlackCorrect());
    }

    private void standardThreeNodesInit() {
        root = new RbNode<>(50, true);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(25);
        root.right = new RbNode<>(75);
    }
}

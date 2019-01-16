package learn.dsai.ch09rbtrees;

import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class RbTreeTest {
    private RbNode<Integer> root;
    private RbTree<Integer> tree;

    @Test
    public void testAddNonBalanced() {
        tree = new RbTree<>();
        tree.addNonBalanced(25, 12, 50);
        assertThat(tree.toString(), is(""
                + "    R:25" + NL
                + "R:12    R:50" + NL
        ));
        tree.addNonBalanced(11, 18, 37, 75);
        assertThat(tree.toString(), is(""
                + "            R:25" + NL
                + "    R:12            R:50" + NL
                + "R:11    R:18    R:37    R:75" + NL
        ));
    }

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
    public void whenFlipAndAttachRedSubNodeThenRedBlackCorrect() {
        standardThreeNodesInit();
        tree.flipColor(root);
        root.left.left = new RbNode<>(12);
        assertTrue(tree.isRedBlackCorrect());
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

    @Test
    public void whenAttachTwoSubNodesThenRedBlackNotCorrect() {
        standardThreeNodesInit();
        assertTrue(tree.isRedBlackCorrect());
        tree.flipColor(root);
        root.left.left = new RbNode<>(12);
        assertTrue(tree.isRedBlackCorrect());
        root.left.left.left = new RbNode<>(6);
        assertFalse(tree.isRedBlackCorrect());
    }

    /* Test Black Height */
    @Test
    public void whenOneBlackThenBlackHeightEqual() {
        root = new RbNode<>(20, true);
        tree = new RbTree<>(root);
        assertThat(tree.blackHeightsEqual(root), is(true));
    }

    @Test
    public void whenSubNodesRedBlackThenBlackHeightNotEqual() {
        root = new RbNode<>(20, true);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(10, false);
        root.right = new RbNode<>(30, true);
        assertThat(tree.blackHeightsEqual(root), is(false));
    }

    @Test
    public void whenSubNodesRedBlackButSubSubNodesDifferThenBlackHeightEqual() {
        root = new RbNode<>(50, true);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(25, false);
        root.right = new RbNode<>(75, true);
        root.left.left = new RbNode<>(12, true);
        root.left.right = new RbNode<>(37, true);
        root.right.left = new RbNode<>(60, false);
        root.right.right = new RbNode<>(85, false);
        assertThat(tree.blackHeightsEqual(root), is(true));
    }

    /* Test Rotations */
    @Test
    public void whenRotateRightRootThenRotated() {
        standardThreeNodesInit();
        tree.rotateRight(null, root);
        root = tree.getRoot();
        assertThat(root.data, is(25));
        assertThat(root.right.data, is(50));
        assertThat(root.right.right.data, is(75));
    }

    @Test
    public void whenRotateRightThenRotated() {
        standardThreeNodesInit();
        root.left.left = new RbNode<>(12);
        root.left.right = new RbNode<>(37);
        tree.rotateRight(root, root.left);
        assertThat(root.left.data, is(12));
        assertThat(root.left.right.data, is(25));
        assertThat(root.left.right.right.data, is(37));
    }

    @Test
    public void whenRotateLeftThenRotated() {
        standardThreeNodesInit();
        root.left.left = new RbNode<>(12);
        root.left.right = new RbNode<>(37);
        tree.rotateLeft(root, root.left);
        assertThat(root.left.data, is(37));
        assertThat(root.left.left.data, is(25));
        assertThat(root.left.left.left.data, is(12));
    }

    @Test
    public void whenRotateRightThenCrossoverNodeMovesRight() {
        standardThreeNodesInit();
        root.left.left = new RbNode<>(12);
        root.left.right = new RbNode<>(37);
        tree.rotateRight(null, root);
        root = tree.getRoot();
        assertThat(root.data, is(25));
        assertThat(root.left.data, is(12));
        assertThat(root.right.data, is(50));
        assertThat(root.right.left.data, is(37));
        assertThat(root.right.right.data, is(75));
    }

    @Test
    public void whenRotateLeftThenCrossoverNodeMovesLeft() {
        standardThreeNodesInit();
        root.right.left = new RbNode<>(60);
        root.right.right = new RbNode<>(85);
        tree.rotateLeft(null, root);
        root = tree.getRoot();
        assertThat(root.data, is(75));
        assertThat(root.right.data, is(85));
        assertThat(root.left.data, is(50));
        assertThat(root.left.left.data, is(25));
        assertThat(root.left.right.data, is(60));
    }

    private void standardThreeNodesInit() {
        root = new RbNode<>(50, true);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(25);
        root.right = new RbNode<>(75);
    }
}

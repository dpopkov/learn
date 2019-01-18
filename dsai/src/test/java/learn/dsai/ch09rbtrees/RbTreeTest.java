package learn.dsai.ch09rbtrees;

import org.junit.Test;

import static learn.dsai.ch09rbtrees.RbNode.*;
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
                "B:10" + NL
        ));
    }

    @Test
    public void whenFlipColorThenColorsChange() {
        root = new RbNode<>(10, RED);
        root.left = new RbNode<>(5, BLACK);
        root.right = new RbNode<>(15, BLACK);
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
        root = new RbNode<>(10, RED);
        tree = new RbTree<>(root);
        assertFalse(tree.isRedBlackCorrect());
    }

    @Test
    public void whenRootIsBlackThenRedBlackCorrect() {
        root = new RbNode<>(10, BLACK);
        tree = new RbTree<>(root);
        assertTrue(tree.isRedBlackCorrectByColor(root));
    }

    @Test
    public void whenNodeRedChildrenRedThenNotRedBlackCorrect() {
        root = new RbNode<>(10, RED);
        root.left = new RbNode<>(5, RED);
        root.right = new RbNode<>(15, RED);
        tree = new RbTree<>(root);
        assertFalse(tree.isRedBlackCorrectByColor(root));
    }

    @Test
    public void whenNodeRedChildrenBlackThenRedBlackCorrect() {
        root = new RbNode<>(10, RED);
        root.left = new RbNode<>(5, BLACK);
        root.right = new RbNode<>(15, BLACK);
        tree = new RbTree<>(root);
        assertTrue(tree.isRedBlackCorrectByColor(root));
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
        root = new RbNode<>(20, BLACK);
        tree = new RbTree<>(root);
        assertThat(tree.blackHeightsEqual(root), is(true));
    }

    @Test
    public void whenSubNodesRedBlackThenBlackHeightNotEqual() {
        root = new RbNode<>(20, BLACK);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(10, RED);
        root.right = new RbNode<>(30, BLACK);
        assertThat(tree.blackHeightsEqual(root), is(false));
    }

    @Test
    public void whenSubNodesRedBlackButSubSubNodesDifferThenBlackHeightEqual() {
        root = new RbNode<>(50, BLACK);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(25, RED);
        root.right = new RbNode<>(75, BLACK);
        root.left.left = new RbNode<>(12, BLACK);
        root.left.right = new RbNode<>(37, BLACK);
        root.right.left = new RbNode<>(60, RED);
        root.right.right = new RbNode<>(85, RED);
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

    /* Test restoring Red-Black rules */
    @Test
    public void whenAddToBlackRootAndRedChildrenThenFlipsColors() {
        standardThreeNodesInit();
        assertThat(root.isBlack(), is(true));
        assertThat(root.left.isRed(), is(true));
        assertThat(root.right.isRed(), is(true));
        tree.add(12);
        assertThat(root.isBlack(), is(true));
        assertThat(root.left.isBlack(), is(true));
        assertThat(root.right.isBlack(), is(true));
    }

    /* Test adding with rotations after insert */
    @Test
    public void whenAddInBestOrderThenBalanced() {
        tree = new RbTree<>();
        tree.add(50, 25, 75, 12, 38, 60, 85);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:25            B:75" + NL
                + "R:12    R:38    R:60    R:85" + NL
        ));
    }

    @Test
    public void whenAddLeftOutsideChildThenRotatesRight() {
        tree = new RbTree<>();
        tree.add(50, 25, 75);
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    R:75" + NL
        ));
        tree.add(12, 11);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:12            B:75" + NL
                + "R:11    R:25    ----    ----" + NL
        ));
    }

    @Test
    public void whenAddRightOutsideChildThenRotatesLeft() {
        tree = new RbTree<>();
        tree.add(50, 25, 75);
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    R:75" + NL
        ));
        tree.add(85, 95);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:25            B:85" + NL
                + "----    ----    R:75    R:95" + NL
        ));
    }

    @Test
    public void whenAddRightInsideChildThenRotatesLeftRotatesRight() {
        tree = new RbTree<>();
        tree.add(50, 25, 75);
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    R:75" + NL
        ));
        tree.add(12, 18);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:18            B:75" + NL
                + "R:12    R:25    ----    ----" + NL
        ));
    }

    @Test
    public void whenAddLeftInsideChildThenRotatesRightRotatesLeft() {
        tree = new RbTree<>();
        tree.add(50, 25, 75);
        assertThat(tree.toString(), is(""
                + "    B:50" + NL
                + "R:25    R:75" + NL
        ));
        tree.add(85, 80);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:25            B:80" + NL
                + "----    ----    R:75    R:85" + NL
        ));
    }

    /* Test adding with rotations on the way down */
    @Test
    public void whenThenRotatesRight() {
        tree = new RbTree<>();
        tree.add(50, 25, 75, 12, 37);
        assertThat(tree.toString(), is(""
                + "            B:50" + NL
                + "    B:25            B:75" + NL
                + "R:12    R:37    ----    ----" + NL
        ));
        tree.add(11, 18);
        assertThat(tree.toString(), is(""
                + "                            B:50" + NL
                + "            R:25                            B:75" + NL
                + "    B:12            B:37            ----            ----" + NL
                + "R:11    R:18    ----    ----    ----    ----    ----    ----" + NL
        ));
        // TODO: add(10) and make assert, tree should be balanced after rotation
    }

    private void standardThreeNodesInit() {
        root = new RbNode<>(50, BLACK);
        tree = new RbTree<>(root);
        root.left = new RbNode<>(25, RED);
        root.right = new RbNode<>(75, RED);
    }
}

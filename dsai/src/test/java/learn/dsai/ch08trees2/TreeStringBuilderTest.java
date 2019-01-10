package learn.dsai.ch08trees2;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TreeStringBuilderTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testBuildingNotFullTree() {
        BSTree.Node<Integer> root = new BSTree.Node<>(40);
        BSTree<Integer> tree = new BSTree<>(root);
        tree.insert(20);
        tree.insert(10);
        tree.insert(60);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(2, true);
        String expected = ".............." + NL
                + "      40" + NL
                + "  20      60" + NL
                + "10  --  --  --" + NL
                + ".............." + NL;
        assertThat(builder.build(root), is(expected));
    }

    @Test
    public void testBuildingFullTree() {
        BSTree.Node<Integer> root = new BSTree.Node<>(40);
        BSTree<Integer> tree = new BSTree<>(root);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(2, true);
        String expected = ".............." + NL
                + "      40" + NL
                + "  20      60" + NL
                + "10  30  50  70" + NL
                + ".............." + NL;
        assertThat(builder.build(root), is(expected));
    }

    @Test
    public void testBuilding3CellWidth() {
        BSTree.Node<Integer> root = new BSTree.Node<>(40);
        BSTree<Integer> tree = new BSTree<>(root);
        tree.insert(20);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(3, true);
        String expected = "........." + NL
                + "    40" + NL
                + " 20   ---" + NL
                + "........." + NL;
        assertThat(builder.build(root), is(expected));
    }

    @Test
    public void whenGetHeightThenReturnsHeight() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(50, 25, 75, 12, 37, 43, 30, 33, 87, 93, 97);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(2, true);
        assertThat(builder.getHeight(tree.getRoot()), is(5));
    }

    @Test
    public void testBuilding() {
        BSTree<Integer> tree = new BSTree<>();
        tree.insert(50, 25, 75, 12, 37, 43/*, 30, 33, 87, 93, 97*/);
        TreeStringBuilder<Integer> builder = new TreeStringBuilder<>(2, true);
        String expected =
                ".............................." + NL
                + "              50" + NL
                + "      25              75" + NL
                + "  12      37      --      --" + NL
                + "--  --  --  43  --  --  --  --" + NL
                + ".............................." + NL;
        assertThat(builder.build(tree.getRoot()), is(expected));
    }
}

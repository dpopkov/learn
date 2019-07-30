package learn.dsajg6e.ch08trees;

import learn.dsajg6e.tools.SystemOutBuffer;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AbstractTreeTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void iteratorCanIterate() {
        Iterator<Integer> it = LinkedBinaryTree.of(20, 10, 30).iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(30));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void canTraversePostOrder() {
        var it = LinkedBinaryTree.of(20, 10, 30).postOrder().iterator();
        assertThat(it.next().getElement(), is(10));
        assertThat(it.next().getElement(), is(30));
        assertThat(it.next().getElement(), is(20));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void canTraverseBreadthFirst() {
        var it = LinkedBinaryTree.of(20, 10, 30).breadthFirst().iterator();
        assertThat(it.next().getElement(), is(20));
        assertThat(it.next().getElement(), is(10));
        assertThat(it.next().getElement(), is(30));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void canPrintPreOrderLabeled() {
        LinkedBinaryTree<String> tree = LinkedBinaryTree.of("Algorithms", "Primer", "OOP",
                "Classes", "Strings", "Inheritance", "Exceptions");
        String expected = String.join(NL,
                "Algorithms",
                "  1 Primer",
                "    1.1 Classes",
                "    1.2 Strings",
                "  2 OOP",
                "    2.1 Inheritance",
                "    2.2 Exceptions") + NL;
        String result;
        try (SystemOutBuffer buffer = new SystemOutBuffer()) {
            tree.printPreOrderLabeled();
            result = buffer.toString();
        }
        assertThat(result, is(expected));
    }
}

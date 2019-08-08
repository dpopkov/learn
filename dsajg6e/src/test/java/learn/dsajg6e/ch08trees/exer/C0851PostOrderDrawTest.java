package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.AbstractTree;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0851PostOrderDrawTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testDraw() {
        AbstractTree<Integer> tree = LinkedBinaryTree.of(20, 10, 30, 5, 15, 25, 35);
        String result = new C0851PostOrderDraw<>(tree, 3).draw();
        String expected = String.join(NL,
                "                   20",
                        "       10       30",
                        "  5 15    25 35") + NL;
        assertThat(result, is(expected));
    }
}

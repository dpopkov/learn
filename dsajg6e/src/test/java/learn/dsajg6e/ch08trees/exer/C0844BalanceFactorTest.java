package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import learn.dsajg6e.tools.SystemOutBuffer;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0844BalanceFactorTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testPrintBalanceFactors() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var r20 = tree.addRoot(20);
        var p10 = tree.addLeft(r20, 10);
        tree.addRight(r20, 30);
        var p05 = tree.addLeft(p10, 5);
        tree.addRight(p10, 15);
        tree.addLeft(p05, 2);
        tree.addRight(p05, 7);
        String result;
        try (SystemOutBuffer buffer = new SystemOutBuffer()) {
            new C0844BalanceFactor().printBalanceFactors(tree);
            result = buffer.toString();
        }
        String expected = String.join(NL,
                "5 : 0",
                "10 : 1",
                "20 : 2") + NL;
        assertThat(result, is(expected));
    }
}

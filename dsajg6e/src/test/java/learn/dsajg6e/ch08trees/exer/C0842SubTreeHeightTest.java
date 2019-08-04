package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.tools.SystemOutBuffer;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0842SubTreeHeightTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testPrintHeights() {
        C0842SubTreeHeight<Integer> tree = new C0842SubTreeHeight<>();
        var r20 = tree.addRoot(20);
        var p10 = tree.add(r20, 10);
        tree.add(r20, 30);
        var p05 = tree.add(p10, 5);
        tree.add(p10, 15);
        tree.add(p05, 2);
        tree.add(p05, 7);
        String out;
        try (SystemOutBuffer buffer = new SystemOutBuffer()) {
            tree.printHeights();
            out = buffer.toString();
        }
        String expected = String.join(NL,
                "2 : 0",
                "7 : 0",
                "5 : 1",
                "15 : 0",
                "10 : 2",
                "30 : 0",
                "20 : 3")  + NL;
        assertThat(out, is(expected));
    }
}

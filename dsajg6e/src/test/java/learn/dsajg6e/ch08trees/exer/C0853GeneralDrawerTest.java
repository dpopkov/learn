package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class C0853GeneralDrawerTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testDraw() {
        NTree<Integer> tree = new NTree<>();
        var root = tree.addRoot(40);
        var p20 = tree.add(root, 20);
        var p60 = tree.add(root, 60);
        tree.add(p20, 10);
        tree.add(p20, 25);
        tree.add(p20, 30);
        tree.add(p60, 50);
        tree.add(p60, 55);
        tree.add(p60, 70);
        tree.add(p60, 75);
        String expected = "             40" + NL
                + "    20                60" + NL
                + " 10    25 30    50 55    70 75" + NL;
        C0853GeneralDrawer<Integer> drawer = new C0853GeneralDrawer<>(tree, 3);
        String result = drawer.draw();
        assertThat(result, is(expected));
    }
}

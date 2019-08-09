package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0855LowestCommonAncestorTest {

    @Test
    public void testLca() {
        C0855LowestCommonAncestor<Integer> tree = new C0855LowestCommonAncestor<>();
        var root = tree.addRoot(40);
        var p20 = tree.add(root, 20);
        var p60 = tree.add(root, 60);
        var p10 = tree.add(p20, 10);
        var p25 = tree.add(p20, 25);
        var p05 = tree.add(p10, 5);
        var p27 = tree.add(p25, 27);
        Position<Integer> result = tree.lca(p05, p27);
        assertThat(result.getElement(), is(20));
        var p55 = tree.add(p60, 55);
        var p57 = tree.add(p55, 57);
        var p56 = tree.add(p57, 56);
        result = tree.lca(p27, p56);
        assertThat(result.getElement(), is(40));
    }
}

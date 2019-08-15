package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0860RomanPositionsTest {

    @Test
    public void testIsRomanPosition() {
        C0860RomanPositions<Integer> tree = new C0860RomanPositions<>();
        LinkedBinaryTree.populate(tree, 20, 10, 30);
        boolean rst = tree.isRomanPosition(tree.root());
        assertThat(rst, is(true));

        var p10 = tree.left(tree.root());
        var p05 = tree.addLeft(p10, 5);
        var p15 = tree.addRight(p10, 15);
        tree.addLeft(p05, 2);
        tree.addRight(p05, 6);
        tree.addLeft(p15, 12);
        tree.addRight(p15, 17);
        rst = tree.isRomanPosition(tree.root());
        assertThat(rst, is(false));

        var p30 = tree.right(tree.root());
        tree.addLeft(p30, 28);
        rst = tree.isRomanPosition(tree.root());
        assertThat(rst, is(true));
    }
}

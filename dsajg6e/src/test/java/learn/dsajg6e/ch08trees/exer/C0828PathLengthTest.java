package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0828PathLengthTest {

    @Test
    public void testPathLength() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var r = tree.addRoot(20);
        var p0 = tree.addLeft(r, 10);
        var p1 = tree.addRight(r, 30);
        tree.addRight(p0, 15);
        tree.addLeft(p1, 25);
        int path = new C0828PathLength().pathLength(tree);
        assertThat(path, is(6));
    }
}

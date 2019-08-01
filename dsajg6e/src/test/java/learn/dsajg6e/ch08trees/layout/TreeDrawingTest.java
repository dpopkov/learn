package learn.dsajg6e.ch08trees.layout;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static learn.dsajg6e.ch08trees.layout.Point2d.of;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeDrawingTest {

    @Test
    public void testLayout() {
        LinkedBinaryTree<CoordinatesXY> tree = LinkedBinaryTree.of(
                of(1, 1),
                of(1, 1),
                of(1, 1)
        );
        int rightX = TreeDrawing.layout(tree, tree.root(), 0, 0);
        assertThat(rightX, is(3));
        var root = tree.root();
        assertPosition(root, 1, 0);
        assertPosition(tree.left(root), 0, 1);
        assertPosition(tree.right(root), 2, 1);
    }

    private void assertPosition(Position<CoordinatesXY> position, int x, int y) {
        assertThat(position.getElement().getX(), is(x));
        assertThat(position.getElement().getY(), is(y));
    }
}

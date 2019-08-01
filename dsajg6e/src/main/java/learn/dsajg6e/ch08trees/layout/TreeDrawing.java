package learn.dsajg6e.ch08trees.layout;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.BinaryTree;

public class TreeDrawing {
    /**
     * Computes coordinates at which to draw positions of a binary tree.
     * The initial call should be {@code layout(tree, tree.root(), 0, 0)}.
     * @param tree binary tree
     * @param p starting position
     * @param depth starting depth
     * @param x coordinate x that should be assigned to the leftmost node of the current subtree
     * @param <E> type of element
     * @return coordinate x that is appropriate for the first node drawn to the right of the subtree
     */
    public static <E extends CoordinatesXY> int layout(BinaryTree<E> tree, Position<E> p, int depth, int x) {
        if (tree.left(p) != null) {
            x = layout(tree, tree.left(p), depth + 1, x);
        }
        p.getElement().setX(x++);
        p.getElement().setY(depth);
        if (tree.right(p) != null) {
            x = layout(tree, tree.right(p), depth + 1, x);
        }
        return x;
    }
}

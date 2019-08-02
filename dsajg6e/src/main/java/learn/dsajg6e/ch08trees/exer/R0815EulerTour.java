package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.BinaryTree;

/**
 * Use Euler tour traversal to compute the level number of each position in a binary tree.
 * Level number:<br>
 * f(left) = f(parent) * 2 + 1<br>
 * f(right) = f(parent) * 2 + 2<br>
 */
public class R0815EulerTour<E extends Int> {
    /** Computes level numbers for all nodes in the tree. */
    public void levelNumber(BinaryTree<E> tree) {
        tree.root().getElement().setInt(0);
        eulerTour(tree, tree.root());
    }

    private void eulerTour(BinaryTree<E> tree, Position<E> p) {
        int parentNumber = p.getElement().getInt();
        Position<E> left = tree.left(p);
        if (left != null) {
            left.getElement().setInt(parentNumber * 2 + 1);
            eulerTour(tree, left);
        }
        Position<E> right = tree.right(p);
        if (right != null) {
            right.getElement().setInt(parentNumber * 2 + 2);
            eulerTour(tree, right);
        }
    }
}

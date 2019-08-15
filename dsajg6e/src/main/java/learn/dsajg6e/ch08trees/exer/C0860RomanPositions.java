package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;

/* Not finished */
public class C0860RomanPositions<E> extends LinkedBinaryTree<E> {

    public boolean isRomanPosition(Position<E> p) {
        Position<E> left = left(p);
        Position<E> right = right(p);
        int numLeftSubtree = treeSize(left);
        int numRightSubtree = treeSize(right);
        int diff = Math.abs(numLeftSubtree - numRightSubtree);
        return diff <= 5;
    }

    private int treeSize(Position<E> p) {
        int sum = 1;
        if (left(p) != null) {
            sum += treeSize(left(p));
        }
        if (right(p) != null) {
            sum += treeSize(right(p));
        }
        return sum;
    }
}

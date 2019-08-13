package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;

public class C0860RomanPositions<E> extends LinkedBinaryTree<E> {
    /* todo: Remove this method when the class is complete. */
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.numChildren(tree.root());
        tree.size();
    }

    public boolean isRomanPosition(Position<E> p) {
        Position<E> left = left(p);
        Position<E> right = right(p);
        int numLeftSubtree = treeSize(left);
        int numRightSubtree = treeSize(right);
        int diff = Math.abs(numLeftSubtree - numRightSubtree);
        return diff <= 5;
    }

    public int treeSize(Position<E> p) {
        return treeSize(p, 1);
    }

    // todo: watch at parameter 'sum'
    private int treeSize(Position<E> p, int sum) {
        if (left(p) != null) {
            sum += treeSize(left(p), 1);
        }
        if (right(p) != null) {
            sum += treeSize(right(p), 1);
        }
        return sum;
    }
}

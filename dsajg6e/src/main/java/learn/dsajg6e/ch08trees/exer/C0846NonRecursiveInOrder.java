package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains non-recursive method for performing in-order traversal of
 * a binary tree.
 */
public class C0846NonRecursiveInOrder<E> extends LinkedBinaryTree<E> {
    /** Non-recursive in-order traversal */
    public Iterable<Position<E>> inOrderNonRec() {
        List<Position<E>> snapshot = new ArrayList<>();
        BinaryNode<E> node = findMostLeft((BinaryNode<E>) root());
        while (node != null) {
            snapshot.add(node);
            var right = right(node);
            if (isLeftSubTree(node) && right == null) {
                node = node.getParent();
            } else if (right != null) {
                node = findMostLeftInRightSubTree(node);
            } else {
                node = findParentOfLeftSubTree(node);
            }
        }
        return snapshot;
    }
}

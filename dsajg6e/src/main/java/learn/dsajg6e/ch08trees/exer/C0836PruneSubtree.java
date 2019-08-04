package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;

public class C0836PruneSubtree<E> extends LinkedBinaryTree<E> {
    public int pruneSubtree(Position<E> p) {
        int count = 1;
        for (Position<E> c : children(p)) {
            count += pruneSubtree(c);
        }
        remove(p);
        return count;
    }

    /* C-8.37 - Swap */
    public void swap(Position<E> p, Position<E> q) {
        Node<E> n0 = validate(p);
        Node<E> n1 = validate(q);
        Node<E> p0 = n0.getParent();
        Node<E> p1 = n1.getParent();
        if (p0 == p1) {
            swapSiblings(p0, n0, n1);
        } else {
            swapNonSiblings(p0, n0, p1, n1);
        }
    }

    private void swapNonSiblings(Node<E> p0, Node<E> n0, Node<E> p1, Node<E> n1) {
        if (n0 == left(p0)) {
            p0.setLeft(n1);
            if (n1 == left(p1)) {
                p1.setLeft(n0);
            } else {
                p1.setRight(n0);
            }
        } else {
            p0.setRight(n1);
            if (n1 == left(p1)) {
                p1.setLeft(n0);
            } else {
                p1.setRight(n0);
            }
        }
    }

    private void swapSiblings(Node<E> parent, Node<E> n0, Node<E> n1) {
        if (n0 == left(parent)) {
            parent.setRight(n0);
            parent.setLeft(n1);
        } else {
            parent.setRight(n1);
            parent.setLeft(n0);
        }
    }
}

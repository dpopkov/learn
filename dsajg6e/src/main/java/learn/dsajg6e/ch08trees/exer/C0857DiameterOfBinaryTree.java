package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;

/* Not efficient version */
public class C0857DiameterOfBinaryTree<E> extends LinkedBinaryTree<E> {

    public Position<E> min() {
        Position<E> n = root();
        while (left(n) != null) {
            n = left(n);
        }
        return n;
    }

    public Position<E> max() {
        Position<E> n = root();
        while (right(n) != null) {
            n = right(n);
        }
        return n;
    }

    /** Returns the distance between two positions in the tree.
      Where distance = depthP + depthQ - 2 * depthOfCommonAncestor. */
    public int distance(Position<E> p, Position<E> q) {
        BinaryNode<E> binP = (BinaryNode<E>) p;
        BinaryNode<E> binQ = (BinaryNode<E>) q;
        int depthP = depth(p);
        int depthQ = depth(q);
        if (depthP < depthQ) {
            int n = depthQ - depthP;
            for (int i = 0; i < n; i++) {
                binQ = binQ.getParent();
            }
        } else if (depthP > depthQ) {
            int n = depthP - depthQ;
            for (int i = 0; i < n; i++) {
                binP = binP.getParent();
            }
        }
        BinaryNode<E> parentP = binP.getParent();
        BinaryNode<E> parentQ = binQ.getParent();
        while (parentP != null && parentP != parentQ) {
            parentP = parentP.getParent();
            parentQ = parentQ.getParent();
        }
        BinaryNode<E> ancestor = parentP;
        int depthAncestor = depth(ancestor);
        return depthP + depthQ - 2 * depthAncestor;
    }

    /** Returns the diameter of the tree - the maximum distance between positions. */
    public int diameter() {
        return distance(min(), max());
    }
}

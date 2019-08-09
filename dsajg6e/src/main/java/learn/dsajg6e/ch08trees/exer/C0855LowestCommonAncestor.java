package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;

public class C0855LowestCommonAncestor<E> extends NTree<E> {

    /** Returns the lowest common ancestor of two positions. */
    public Position<E> lca(Position<E> p, Position<E> q) {
        Node<E> nP = validate(p);
        Node<E> nQ = validate(q);
        Node<E> parentP = nP.getParent();
        Node<E> parentQ = nQ.getParent();
        int dp = depth(p);
        int dq = depth(q);
        if (dp < dq) {
            for (int i = 0; i < dq - dp; i++) {
                parentQ = parentQ.getParent();
            }
        } else if (dp > dq) {
            for (int i = 0; i < dp - dq; i++) {
                parentP = parentP.getParent();
            }
        }
        while (parentP != null && parentP != parentQ) {
            parentP = parentP.getParent();
            parentQ = parentQ.getParent();
        }
        return parentP;
    }
}

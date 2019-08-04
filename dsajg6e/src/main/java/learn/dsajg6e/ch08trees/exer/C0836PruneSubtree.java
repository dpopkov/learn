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
}

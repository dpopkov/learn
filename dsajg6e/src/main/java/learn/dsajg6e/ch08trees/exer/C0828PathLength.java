package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.Tree;

/**
 * The path length of a tree is the sum of the depth of all positions in the tree.
 */
public class C0828PathLength {
    public <E> int pathLength(Tree<E> tree) {
        return pathLengthChildren(tree, tree.root(), 0);
    }

    private <E> int pathLengthChildren(Tree<E> tree, Position<E> position, int positionDepth) {
        int total = positionDepth;
        for (Position<E> c : tree.children(position)) {
            total += pathLengthChildren(tree, c, positionDepth + 1);
        }
        return total;
    }
}

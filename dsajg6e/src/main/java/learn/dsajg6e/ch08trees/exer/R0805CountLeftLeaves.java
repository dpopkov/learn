package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.BinaryTree;

public class R0805CountLeftLeaves {

    public <E> int countLeftLeaves(BinaryTree<E> tree) {
        return countLeftLeaves(tree, tree.root());
    }

    private <E> int countLeftLeaves(BinaryTree<E> tree, Position<E> position) {
        if (position == null) {
            return 0;
        }
        int count = 0;
        Position<E> left = tree.left(position);
        if (left != null) {
            if (tree.isExternal(left)) {
                count++;
            } else {
                count += countLeftLeaves(tree, left);
            }
        }
        count += countLeftLeaves(tree, tree.right(position));
        return count;
    }
}

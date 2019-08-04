package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.AbstractBinaryTree;

public class C0844BalanceFactor {
    public <E> void printBalanceFactors(AbstractBinaryTree<E> tree) {
        printNodeBalanceFactor(tree, tree.root());
    }

    /** Prints balance factor and returns height of the sub-tree. */
    private <E> int printNodeBalanceFactor(AbstractBinaryTree<E> tree, Position<E> p) {
        if (tree.isExternal(p)) {
            return 0;
        }
        Position<E> left = tree.left(p);
        Position<E> right = tree.right(p);
        int leftHeight = 1 + printNodeBalanceFactor(tree, left);
        int rightHeight = 1 + printNodeBalanceFactor(tree, right);
        int balance = leftHeight - rightHeight;
        System.out.printf("%s : %d%n", p.getElement(), balance);
        return Math.max(leftHeight, rightHeight);
    }
}

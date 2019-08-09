package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.AbstractTree;

public class C0853GeneralDrawer<E> extends AbstractTreeDrawer<E> {

    public C0853GeneralDrawer(AbstractTree<E> tree, int cellWidth) {
        super(tree, cellWidth);
    }

    @Override
    public String draw() {
        if (!(tree instanceof OrderedTree)) {
            throw new IllegalStateException("Can draw ordered trees only");
        }
        @SuppressWarnings("unchecked")
        OrderedTree<E> orderedTree = (OrderedTree<E>) tree;
        return draw(orderedTree::inOrder);
    }
}

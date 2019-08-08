package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.AbstractTree;

public class C0850PreOrderDraw<E> extends AbstractTreeDrawer<E> {
    public C0850PreOrderDraw(AbstractTree<E> tree, int cellWidth) {
        super(tree, cellWidth);
    }

    @Override
    public String draw() {
        return super.draw(tree::preOrder);
    }
}

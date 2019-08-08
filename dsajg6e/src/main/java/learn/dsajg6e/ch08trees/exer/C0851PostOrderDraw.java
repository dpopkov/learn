package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.AbstractTree;

public class C0851PostOrderDraw<E> extends AbstractTreeDrawer<E> {
    public C0851PostOrderDraw(AbstractTree<E> tree, int cellWidth) {
        super(tree, cellWidth);
    }

    @Override
    public String draw() {
        return super.draw(tree::postOrder);
    }
}

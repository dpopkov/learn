package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.AbstractTree;
import learn.dsajg6e.tools.CharDisplay;

import java.util.function.Supplier;

public abstract class AbstractTreeDrawer<E> {
    protected final int cellWidth;
    protected final AbstractTree<E> tree;

    public AbstractTreeDrawer(AbstractTree<E> tree, int cellWidth) {
        this.tree = tree;
        this.cellWidth = cellWidth;
    }

    public abstract String draw();

    protected String draw(Supplier<Iterable<Position<E>>> order) {
        int x = 0;
        CharDisplay buffer = new CharDisplay(cellWidth);
        for (Position<E> pos : order.get()) {
            int depth = tree.depth(pos);
            buffer.add(pos.getElement(), x, depth);
            x++;
        }
        return buffer.toString();
    }
}

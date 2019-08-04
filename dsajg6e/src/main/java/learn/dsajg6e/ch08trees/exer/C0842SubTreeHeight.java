package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;

public class C0842SubTreeHeight<E> extends NTree<E> {
    public void printHeights() {
        printHeightsPostOrder(root());
    }

    private int printHeightsPostOrder(Position<E> p) {
        int height = 0;
        if (isInternal(p)) {
            for (Position<E> c : children(p)) {
                int h = printHeightsPostOrder(c);
                height = Math.max(height, h + 1);
            }
        }
        System.out.printf("%s : %d%n", p.getElement(), height);
        return height;
    }
}

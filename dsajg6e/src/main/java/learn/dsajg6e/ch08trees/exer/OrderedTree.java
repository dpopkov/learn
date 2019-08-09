package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;

public interface OrderedTree<E> {
    Iterable<Position<E>> inOrder();
}

package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

public interface AppendableBinaryTree<E> {
    Position<E> addRoot(E e) throws IllegalStateException;
    Position<E> addLeft(Position<E> p, E e);
    Position<E> addRight(Position<E> p, E e);
    E set(Position<E> p, E e);
}

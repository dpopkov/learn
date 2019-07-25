package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 * @param <E> type of elements in the tree
 */
public interface Tree<E> extends Iterable<E> {
    /** Returns the position of the root of the tree (or null if empty). */
    Position<E> root();

    /** Returns the position of the parent of position p (or null if p is the root). */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /** Returns an iterable collection containing the children of position p (if any). */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /** Returns the number of children of position p. */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /** Returns true if position p has at least one child. */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /** Returns true if position p does not have any children. */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /** Returns true if position p is the root of the tree. */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /** Returns the number of positions (and hence elements) that are contained in the tree. */
    int size();

    /** Returns true if the tree does not contain any positions (and thus no elements). */
    boolean isEmpty();

    /** Returns an iterator for all elements in the tree. */
    Iterator<E> iterator();

    /** Returns an iterable collection of all positions of the tree. */
    Iterable<Position<E>> positions();
}

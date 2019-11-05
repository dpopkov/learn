package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;

public class SimpleSkipList<E extends Comparable<E>> extends AbstractSkipList<E> {

    public SimpleSkipList(E minKey, E maxKey) {
        super(minKey, maxKey);
    }

    @Override
    public Position<E> put(E key) {

        Position<E> p = search(key);
        if (p.getElement().equals(key)) {
            return p;
        }
        Node<E> node = new Node<>(key);
        Node<E> prev = toNode(p);
        Node<E> next = prev.getRight();
        node.setLeft(prev);
        node.setRight(next);
        prev.setRight(node);
        next.setLeft(node);
        size++;
        return node;
    }

    @Override
    public Position<E> search(E key) {
        Position<E> p = topLeft;
        while (below(p) != null) {
            p = below(p);
            while (next(p).getElement().compareTo(key) <= 0) {
                p = next(p);
            }
            // post-condition: next(p) > key
        }
        // post-condition: below(p) == null  -- we are at the bottom
        return p;
    }

    @Override
    public Position<E> next(Position<E> p) {
        return toNode(p).getRight();
    }

    @Override
    public Position<E> prev(Position<E> p) {
        return toNode(p).getLeft();
    }

    @Override
    public Position<E> above(Position<E> p) {
        return toNode(p).getUp();
    }

    @Override
    public Position<E> below(Position<E> p) {
        return toNode(p).getDown();
    }
}

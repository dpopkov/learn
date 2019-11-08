package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.Random;

public class SimpleSkipList<E extends Comparable<E>> extends AbstractSkipList<E> {
    private static final Random RANDOM = new Random();

    public SimpleSkipList(E minKey, E maxKey) {
        super(minKey, maxKey);
    }

    @Override
    public Position<E> put(E key) {
        Position<E> p = skipSearch(key);
        if (p.getElement().equals(key)) {
            return p;
        }
        Node<E> newNode = new Node<>(key);
        Node<E> prev = (Node<E>) p;
        Node<E> next = prev.getRight();
        insertInRow(prev, newNode, next);
        size++;
        /* Build a tower */
        // todo: refactor to method buildTower
        Node<E> lastInserted = newNode;
        while (RANDOM.nextBoolean()) {
            //      backtrack to higher level
            while (above(prev) == null) {
                prev = (Node<E>) prev(prev);
            }   // post-condition: above(prev) != null
            prev = (Node<E>) above(prev);
            if (prev == topLeft) {
                /* Build one more level */
                // todo: refactor to method buildLevel (m.b get rig of 2nd level in initial state ?)
                Node<E> newTopLeft = topLeft.copy();
                Node<E> newTopRight = topRight.copy();
                connectHorizontal(newTopLeft, newTopRight);
                connectVertical(newTopLeft, topLeft);
                connectVertical(newTopRight, topRight);
                topLeft = newTopLeft;
                topRight = newTopRight;
            }
            //      insert the node
            // todo: refactor to method
            next = (Node<E>) next(prev);
            Node<E> towerNode = lastInserted.copy();
            insertInRow(prev, towerNode, next);
            connectVertical(towerNode, lastInserted);
            lastInserted = towerNode;
        }
        return newNode;
    }

    private void insertInRow(Node<E> prev, Node<E> node, Node<E> next) {
        node.setLeft(prev);
        node.setRight(next);
        prev.setRight(node);
        next.setLeft(node);
    }

    @Override
    public Position<E> skipSearch(E key) {
        Position<E> p = topLeft;
        while (below(p) != null) {
            p = below(p);
            while (key.compareTo(next(p).getElement()) >= 0) {
                p = next(p);
            }   // post-condition: key < next(p)
        }   // post-condition: below(p) == null  -- we are at the bottom
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

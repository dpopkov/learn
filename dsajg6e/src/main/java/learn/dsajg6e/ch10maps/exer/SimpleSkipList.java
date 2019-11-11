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
        insertInRow(prev, newNode, prev.getRight());
        size++;
        return buildTower(prev, newNode);
    }

    private Node<E> buildTower(Node<E> prev, final Node<E> insertedNode) {
        Node<E> lastInserted = insertedNode;
        while (RANDOM.nextBoolean()) {
            while (above(prev) == null) {
                prev = (Node<E>) prev(prev);
            }
            prev = (Node<E>) above(prev);
            if (prev == topLeft) {
                buildNewLevel();
            }
            Node<E> towerTopNode = lastInserted.copy();
            insertInRow(prev, towerTopNode, (Node<E>) next(prev));
            connectVertical(towerTopNode, lastInserted);
            lastInserted = towerTopNode;
        }
        return lastInserted;
    }

    private void buildNewLevel() {
        Node<E> newTopLeft = topLeft.copy();
        Node<E> newTopRight = topRight.copy();
        connectHorizontal(newTopLeft, newTopRight);
        connectVertical(newTopLeft, topLeft);
        connectVertical(newTopRight, topRight);
        topLeft = newTopLeft;
        topRight = newTopRight;
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
    public Position<E> remove(E key) {
        Position<E> p = skipSearch(key);
        if (!p.getElement().equals(key)) {
            return null;
        }
        Node<E> node = (Node<E>) p;
        removeNode(node);
        while (above(node) != null) {
            node = (Node<E>) above(node);
            removeNode(node);
        }
        size--;
        return p;
    }

    private void removeNode(Node<E> node) {
        Node<E> prev = node.getLeft();
        Node<E> next = node.getRight();
        prev.setRight(next);
        next.setLeft(prev);
        node.setRight(null);
        node.setLeft(null);
        Node<E> below = node.getDown();
        if (below != null) {
            below.setUp(null);
            node.setDown(null);
        }
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

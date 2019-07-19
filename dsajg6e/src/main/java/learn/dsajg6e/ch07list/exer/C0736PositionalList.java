package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch07list.positional.PositionalList;

/*
* Implementing PositionalList to include a method, positionAtIndex(i), that returns the position
* of the element having index i (or throws exception). */
public class C0736PositionalList<E> extends LinkedPositionalList<E> implements PositionalList<E> {
    public Position<E> positionAtIndex(int index) {
        int length = super.size();
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        /* C-7.37 */
        if (index < length / 2) {
            return traverseForward(index);
        } else {
            return traverseBackward(index);
        }
    }

    private Position<E> traverseBackward(int index) {
        Position<E> p = super.last();
        for (int i = super.size() - 1; i > index; i--) {
            p = super.before(p);
        }
        return p;
    }

    private Position<E> traverseForward(int index) {
        Position<E> p = super.first();
        for (int i = 0; i < index; i++) {
            p = super.after(p);
        }
        return p;
    }
}

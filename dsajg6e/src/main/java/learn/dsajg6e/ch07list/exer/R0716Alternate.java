package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Positional list that returns an iterator that reports only those
 * elements having even index in the list. */
public class R0716Alternate<E> extends LinkedPositionalList<E> {
    @Override
    public Iterator<E> iterator() {
        return new EvenElementIterator();
    }

    private class EvenElementIterator extends ElementIterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (!super.hasNext()) {
                return false;
            }
            if (index % 2 != 0) {
                super.next();
                index++;
            }
            return super.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            E element = super.next();
            index++;
            if (index % 2 == 0) {
                element = super.next();
                index++;
            }
            return element;
        }
    }
}

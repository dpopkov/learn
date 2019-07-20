package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.Position;

public class PositionInArray<E> implements Position<E> {
    private int index;
    private  E element;

    public PositionInArray(int index, E element) {
        this.index = index;
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "{" + index + ", " + element + '}';
    }

    public void incrementIndex() {
        index++;
    }
}

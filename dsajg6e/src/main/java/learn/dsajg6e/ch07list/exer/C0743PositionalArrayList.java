package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.Position;

/*
Page 281 describes an array-based representation for implementing the positional list ADT.
Give a pseudocode description of the addBefore method for that representation.
 */
public class C0743PositionalArrayList<E> {
    private final PositionInArray<E>[] data;
    private int size;

    @SuppressWarnings({"unchecked"})
    public C0743PositionalArrayList(int capacity) {
        data = (PositionInArray<E>[]) new PositionInArray[capacity];
    }

    public Position<E> last() {
        return data[size - 1];
    }

    public PositionInArray<E> add(E element) {
        int index = size;
        PositionInArray<E> pos = new PositionInArray<>(index, element);
        data[index] = pos;
        size++;
        return pos;
    }

    public int size() {
        return size;
    }

    public PositionInArray<E> addBefore(PositionInArray<E> p, E e) {
        int index = p.getIndex();
        PositionInArray<E> pos = new PositionInArray<>(index, e);
        for (int i = size; i > index; i--) {
            PositionInArray<E> current = data[i - 1];
            current.incrementIndex();
            data[i] = current;
        }
        data[index] = pos;
        size++;
        return pos;
    }

    public E get(int index) {
        return data[index].getElement();
    }
}

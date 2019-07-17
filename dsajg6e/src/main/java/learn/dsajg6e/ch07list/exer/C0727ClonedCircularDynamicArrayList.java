package learn.dsajg6e.ch07list.exer;

public class C0727ClonedCircularDynamicArrayList<E> extends C0726CircularDynamicArrayList<E> implements Cloneable {
    public C0727ClonedCircularDynamicArrayList() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    public C0727ClonedCircularDynamicArrayList<E> clone() throws CloneNotSupportedException {
        C0727ClonedCircularDynamicArrayList<E> clone = (C0727ClonedCircularDynamicArrayList<E>) super.clone();
        clone.data = data.clone();
        return clone;
    }
}

package learn.dsai.ch08trees2;

public interface BNode<T> {
    T getData();
    BNode<T> getLeft();
    BNode<T> getRight();
}

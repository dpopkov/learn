package learn.dsai.ch04.projects;

public interface Deque {
    void insertLeft(long value);
    void insertRight(long value);
    long removeLeft();
    long removeRight();
}

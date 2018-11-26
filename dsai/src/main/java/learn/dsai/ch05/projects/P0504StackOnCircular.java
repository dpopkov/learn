package learn.dsai.ch05.projects;

/**
 * Stack based on circular list.
 */
public class P0504StackOnCircular {
    private final P0503CircularList list = new P0503CircularList();

    public void push(long value) {
        list.insert(value);
    }

    public long pop() {
        return list.delete();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

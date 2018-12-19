package learn.dsai.ch08trees;

/**
 * Node that contains value of type {@code long}.
 * The access level of fields of the node is default (package level)
 * for simplicity of tree implementation.
 */
public class NodeLong {
    final long data;
    NodeLong left;
    NodeLong right;

    public NodeLong(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Long.toString(data);
    }
}

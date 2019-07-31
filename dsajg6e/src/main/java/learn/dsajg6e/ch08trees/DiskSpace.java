package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.nio.file.Path;

/**
 * Computes total disk space occupied by the specified directory.
 */
@SuppressWarnings("unused")
public class DiskSpace {
    private final Path path;

    public DiskSpace(Path directoryPath) {
        this.path = directoryPath;
    }

    public int total() {
        throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /* CF 8.25 */
    private int subTreeSpace(Tree<Integer> tree, Position<Integer> subTreePosition) {
        int subTotal = subTreePosition.getElement();
        for (Position<Integer> c : tree.children(subTreePosition)) {
            subTotal += subTreeSpace(tree, c);
        }
        return subTotal;
    }
}

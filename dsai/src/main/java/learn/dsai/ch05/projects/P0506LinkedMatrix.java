package learn.dsai.ch05.projects;

import java.util.function.Supplier;

/**
 * Two-dimensional linked list.
 * Each link (except those on the top row and left side) is pointed to
 * by the link directly above it and by the link on its left.
 */
public class P0506LinkedMatrix<T> {
    private Supplier<T> dataSupplier;

    private class Link {
        T data;
        Link right;
        Link bottom;

        Link() {
            if (dataSupplier != null) {
                data = dataSupplier.get();
            } else {
                data = null;
            }
        }
    }

    private final Link first;

    public P0506LinkedMatrix(int width, int height) {
        Link row = createBottomRow(width);
        for (int i = 1; i < height; i++) {
            row = createRowOver(row);
        }
        first = row;
    }

    public P0506LinkedMatrix(int width, int height, Supplier<T> testDataSupplier) {
        dataSupplier = testDataSupplier;
        Link row = createBottomRow(width);
        for (int i = 1; i < height; i++) {
            row = createRowOver(row);
        }
        first = row;
    }

    private Link createRowOver(Link below) {
        Link start = new Link();
        start.bottom = below;
        Link current = start;
        Link currentBelow = below.right;
        while (currentBelow != null) {
            Link next = new Link();
            current.right = next;
            next.bottom = currentBelow;
            currentBelow = currentBelow.right;
            current = next;
        }
        return start;
    }

    private Link createBottomRow(int width) {
        Link start = new Link();
        Link link = start;
        for (int i = 1; i < width; i++) {
            Link next = new Link();
            link.right = next;
            link = next;
        }
        return start;
    }

    public void insert(T data, int row, int column) {
        Link lnk = first;
        for (int i = 0; i < row; i++) {
            lnk = lnk.bottom;
        }
        for (int i = 0; i < column; i++) {
            lnk = lnk.right;
        }
        lnk.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link row = first;
        while (row != null) {
            Link col = row;
            while (col != null) {
                if (col.data == null) {
                    builder.append("null");
                } else {
                    builder.append(col.data.toString());
                }
                col = col.right;
                if (col != null) {
                    builder.append(" ");
                }
            }
            row = row.bottom;
            if (row != null) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}

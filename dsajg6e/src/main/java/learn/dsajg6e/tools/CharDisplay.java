package learn.dsajg6e.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Character two-dimensional screen that allows to add objects into textual buffer
 * according to the specified X and Y coordinates,
 * and then return result as one string.
 */
public class CharDisplay {
    private static final String NL = System.lineSeparator();

    private final int deltaX;
    private final String format;
    private final List<StringBuilder> builders = new ArrayList<>();

    public CharDisplay(int deltaX) {
        this.deltaX = deltaX;
        format = String.format("%%%ds", deltaX);
    }

    public void add(Object obj, int x, int y) {
        String padded = String.format(format, obj.toString());
        StringBuilder line = getBuilder(y);
        int pos = x * deltaX;
        if (pos < line.length()) {
            line.replace(pos, pos + padded.length(), padded);
        } else if (pos == line.length()) {
            line.append(padded);
        } else {
            line.append(" ".repeat(pos - line.length()));
            line.append(padded);
        }
    }

    private StringBuilder getBuilder(int y) {
        if (y >= builders.size()) {
            int numToAdd = y - builders.size() + 1;
            for (int i = 0; i < numToAdd; i++) {
                builders.add(new StringBuilder());
            }
        }
        return builders.get(y);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (StringBuilder b : builders) {
            buffer.append(b);
            buffer.append(NL);
        }
        return buffer.toString();
    }
}

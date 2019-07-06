package learn.dsajg6e.ch06stacks;

/**
 * Finds successive tags in a sequence of characters (string).
 */
public class TagFinder {
    private final String input;
    private int start;
    private int end;
    private boolean onTag;

    public TagFinder(String input) {
        this.input = input;
    }

    /** Index of last triangle bracket. */
    public int getLastPosition() {
        return end;
    }

    public boolean hasNext() {
        onTag = false;
        start = input.indexOf('<', end);
        if (start != -1) {
            end = input.indexOf('>', start + 1);
            if (end != -1) {
                onTag = true;
                return true;
            }
        }
        return false;
    }

    public TagPosition next() {
        if (!onTag) {
            start = input.indexOf('<', end);
            if (start == -1) {
                throw new IllegalStateException("No more tags");
            }
            end = input.indexOf('>', start);
            if (end == -1) {
                throw new IllegalStateException("No more tags");
            }
        }
        String tag = input.substring(start + 1, end);
        boolean closing = tag.startsWith("/");
        if (closing) {
            tag = tag.substring(1);
        }
        return new TagPosition(tag, closing, start, end);
    }
}

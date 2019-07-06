package learn.dsajg6e.ch06stacks;

/**
 * Finds successive tags in a sequence of characters (string).
 */
public class TagFinder implements ITagFinder {
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

    @Override
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

    @Override
    public TagPosition next() {
        if (!onTag) {
            findStartEnd();
        }
        String tag = extractTagName(input, start, end);
        boolean closing = tag.startsWith("/");
        if (closing) {
            tag = tag.substring(1);
        }
        return new TagPosition(tag, closing, start, end);
    }

    /**
     * Extracts name of the tag from the specified html input.
     * This method can be overridden in sub-classes.
     * @param html html input
     * @param tagStart index of opening bracket
     * @param tagEnd index of closing bracket
     * @return name of the tag
     */
    protected String extractTagName(String html, int tagStart, int tagEnd) {
        return html.substring(tagStart + 1, tagEnd);
    }

    private void findStartEnd() {
        start = input.indexOf('<', end);
        if (start == -1) {
            throw new IllegalStateException("No more tags");
        }
        end = input.indexOf('>', start);
        if (end == -1) {
            throw new IllegalStateException("No more tags");
        }
    }
}

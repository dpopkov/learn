package learn.dsajg6e.ch06stacks;

import java.util.Objects;

/**
 * Combines name of the tag and starting and ending indexes of the tag.
 */
public class TagPosition {
    private final String tag;
    private final boolean closing;
    /** Index of opening triangle bracket. */
    private final int start;
    /** Index of closing triangle bracket. */
    private final int end;

    private TagPosition(String tag, boolean closing) {
        this(tag, closing, -1, -1);
    }

    public static TagPosition opening(String tag) {
        return new TagPosition(tag, false);
    }

    public static TagPosition closing(String tag) {
        return new TagPosition(tag, true);
    }

    public TagPosition(String tag, boolean closing, int start, int end) {
        this.tag = tag;
        this.closing = closing;
        this.start = start;
        this.end = end;
    }

    public String getTag() {
        return tag;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isClosing() {
        return closing;
    }

    public boolean isOpening() {
        return !closing;
    }

    public boolean match(TagPosition other) {
        if (!this.tag.equals(other.tag)) {
            return false;
        }
        return this.closing ^ other.closing;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TagPosition that = (TagPosition) obj;
        return closing == that.closing && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, closing);
    }

    @Override
    public String toString() {
        return "TagPosition{tag='" + tag + '\'' + ", closing=" + closing + ", start=" + start + ", end=" + end + '}';
    }
}

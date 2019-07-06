package learn.dsajg6e.ch06stacks;

import java.util.function.Function;

/**
 * CF 6.8
 */
public class MatchingTags {
    private final Function<String, ITagFinder> constructor;

    public MatchingTags(Function<String, ITagFinder> constructor) {
        this.constructor = constructor;
    }

    /**
     * Tests if every opening tag has a matching closing tag in html string.
     */
    public boolean isHtmlMatched(String html) {
        ITagFinder finder = constructor.apply(html);
        Stack<TagPosition> stack = new LinkedStack<>();
        while (finder.hasNext()) {
            TagPosition current = finder.next();
            if (current.isOpening()) {
                stack.push(current);
            } else if (stack.isEmpty() || !current.match(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

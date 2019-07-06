package learn.dsajg6e.ch06stacks;

/**
 * CF 6.8
 */
public class MatchingTags {
    /**
     * Tests if every opening tag has a matching closing tag in html string.
     */
    static boolean isHtmlMatched(String html) {
        TagFinder finder = new TagFinder(html);
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

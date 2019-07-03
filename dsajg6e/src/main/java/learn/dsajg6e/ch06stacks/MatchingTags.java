package learn.dsajg6e.ch06stacks;

/**
 * CF 6.8
 */
public class MatchingTags {
    /** Tests if every opening tag has a matching closing tag in html string. */
    static boolean isHtmlMatched(String html) {
        Stack<String> stack = new LinkedStack<>();
        int i = 0;
        while (i < html.length()) {
            int st = html.indexOf('<', i);
            int end = html.indexOf('>', st + 1);
            if (end == -1) {
                return false;
            }
            String tag = html.substring(st + 1, end);
            if (tag.startsWith("/")) {
                tag = tag.substring(1);
                if (stack.isEmpty() || !tag.equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(tag);
            }
            i = end + 1;
        }
        return stack.isEmpty();
    }
}

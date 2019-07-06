package learn.dsajg6e.ch06stacks;

public class AttributedTagFinder extends TagFinder {
    public AttributedTagFinder(String input) {
        super(input);
    }

    @Override
    protected String extractTagName(String html, int tagStart, int tagEnd) {
        int nameStart = tagStart + 1;
        int nameEnd = html.indexOf(' ', nameStart);
        nameEnd = (nameEnd == -1) ? tagEnd : nameEnd;
        return html.substring(nameStart, nameEnd);
    }
}

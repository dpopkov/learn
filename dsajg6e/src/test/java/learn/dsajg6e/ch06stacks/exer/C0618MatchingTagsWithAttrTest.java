package learn.dsajg6e.ch06stacks.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0618MatchingTagsWithAttrTest {

    @Test
    public void whenTagWithAttributeThenTrue() {
        String html = "<tag attr1=\"value1\">content</tag>";
        C0618MatchingTagsWithAttr matcher = new C0618MatchingTagsWithAttr();
        assertThat(matcher.isHtmlMatched(html), is(true));
    }

    @Test
    public void whenMismatchedTagWithAttributeThenFalse() {
        String html = "<tag attr1=\"value1\">content</tag1>";
        C0618MatchingTagsWithAttr matcher = new C0618MatchingTagsWithAttr();
        assertThat(matcher.isHtmlMatched(html), is(false));
    }
}

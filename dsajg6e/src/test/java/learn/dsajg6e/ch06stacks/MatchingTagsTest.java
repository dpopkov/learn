package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MatchingTagsTest {

    @Test
    public void testIsHtmlMatched() {
        MatchingTags matcher = new MatchingTags(TagFinder::new);
        assertThat(matcher.isHtmlMatched("<html></html>"), is(true));
        assertThat(matcher.isHtmlMatched("<html></head></html>"), is(false));
        assertThat(matcher.isHtmlMatched("<html></html><head>"), is(false));
        assertThat(matcher.isHtmlMatched("</html>"), is(false));
    }
}

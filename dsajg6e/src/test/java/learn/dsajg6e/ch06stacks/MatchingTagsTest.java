package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static learn.dsajg6e.ch06stacks.MatchingTags.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class MatchingTagsTest {

    @Test
    public void testIsHtmlMatched() {
        assertThat(isHtmlMatched("<html></html>"), is(true));
        assertThat(isHtmlMatched("<html></head></html>"), is(false));
        assertThat(isHtmlMatched("<html></html><head>"), is(false));
        assertThat(isHtmlMatched("<html"), is(false));
        assertThat(isHtmlMatched("</html>"), is(false));
    }
}

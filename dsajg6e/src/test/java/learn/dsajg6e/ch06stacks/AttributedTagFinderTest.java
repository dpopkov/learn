package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class AttributedTagFinderTest {
    @Test
    public void whenTagsHaveAttributesThenCanFindThem() {
        String html = "<p class=\"test\">";
        ITagFinder finder = new AttributedTagFinder(html);
        assertThat(finder.hasNext(), is(true));
        assertThat(finder.next(), is(TagPosition.opening("p")));
    }
}

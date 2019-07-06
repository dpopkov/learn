package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TagFinderTest {

    @Test
    public void whenTagThenHasNextReturnsTrue() {
        TagFinder finder = new TagFinder("<html>");
        assertThat(finder.hasNext(), is(true));
    }

    @Test
    public void whenNoTagThenHasNextReturnsFalse() {
        TagFinder finder = new TagFinder("html>");
        assertThat(finder.hasNext(), is(false));
    }

    @Test
    public void whenTagThenNextReturnsPosition() {
        TagFinder finder = new TagFinder("<html>");
        TagPosition pos = finder.next();
        assertThat(pos.getTag(), is("html"));
        assertThat(pos.getStart(), is(0));
        assertThat(pos.getEnd(), is(5));
    }

    @Test
    public void canFindSuccessiveTags() {
        //                                      0123456789012
        TagFinder finder = new TagFinder("<html></html>");
        TagPosition pos = finder.next();
        assertThat(pos.isOpening(), is(true));
        assertThat(pos.getTag(), is("html"));
        assertThat(pos.getStart(), is(0));
        assertThat(pos.getEnd(), is(5));
        pos = finder.next();
        assertThat(pos.isClosing(), is(true));
        assertThat(pos.getTag(), is("html"));
        assertThat(pos.getStart(), is(6));
        assertThat(pos.getEnd(), is(12));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNoTagThenException() {
        TagFinder finder = new TagFinder("<html>html");
        assertThat(finder.hasNext(), is(true));
        finder.next();
        assertThat(finder.hasNext(), is(false));
        assertThat(finder.getLastPosition(), is(5));
        finder.next();
    }

    @Test(expected = IllegalStateException.class)
    public void whenNoClosingBracketsThenException() {
        TagFinder finder = new TagFinder("<html></html");
        finder.next();
        finder.next();
    }

    @Test
    public void whenNoClosingBracketThenHasNextReturnsFalse() {
        TagFinder finder = new TagFinder("<html");
        assertThat(finder.hasNext(), is(false));
    }

    @Test
    public void canExtractSuccessiveTags() {
        TagFinder finder = new TagFinder("<html>   <head>  </head> <body>content</body>  </html>");
        List<TagPosition> result = new ArrayList<>();
        while (finder.hasNext()) {
            result.add(finder.next());
        }
        assertThat(result.size(), is(6));
        List<TagPosition> expected = List.of(
                TagPosition.opening("html"),
                TagPosition.opening("head"),
                TagPosition.closing("head"),
                TagPosition.opening("body"),
                TagPosition.closing("body"),
                TagPosition.closing("html")
        );
        assertThat(result, is(expected));
    }
}

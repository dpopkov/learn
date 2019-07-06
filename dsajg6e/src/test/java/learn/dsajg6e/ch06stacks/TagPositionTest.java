package learn.dsajg6e.ch06stacks;

import org.junit.Test;

import static learn.dsajg6e.ch06stacks.TagPosition.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TagPositionTest {

    @Test
    public void canMatchPairTags() {
        assertThat(opening("html").match(closing("html")), is(true));
    }

    @Test
    public void canDetectNonPairTags() {
        assertThat(opening("html").match(opening("html")), is(false));
    }

    @Test
    public void canDetectDifferentTags() {
        assertThat(opening("html").match(closing("head")), is(false));
    }
}

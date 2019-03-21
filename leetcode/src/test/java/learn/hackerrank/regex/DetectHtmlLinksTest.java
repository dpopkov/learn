package learn.hackerrank.regex;

import learn.hackerrank.common.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DetectHtmlLinksTest {
    @Parameterized.Parameters
    public static Collection<Object> testData() {
        return Arrays.asList(new Object[][]{
                {"<a href=\"http://www.hackerrank.com\">HackerRank</a> ",
                    Pair.of("http://www.hackerrank.com", "HackerRank")},
                {"<a href=\"http://www.hackerrank.com\"><b>HackerRank</b></a>",
                        Pair.of("http://www.hackerrank.com", "HackerRank")},
                {"<a href=\"http://www.hackerrank.com\"><h1><b>HackerRank</b></h1></a>",
                        Pair.of("http://www.hackerrank.com", "HackerRank")},
                {"<p><a href=\"http://www.quackit.com/html/tutorial/html_links.cfm\">Example Link</a></p>",
                        Pair.of("http://www.quackit.com/html/tutorial/html_links.cfm", "Example Link")},
                {"<div class=\"more-info\"><a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>",
                        Pair.of("http://www.quackit.com/html/examples/html_links_examples.cfm", "More Link Examples...")},
                {"<li id=\"n-mainpage-description\"><a href=\"/wiki/Main_Page\" title=\"Visit the main page [z]\" accesskey=\"z\">Main page</a></li>",
                        Pair.of("/wiki/Main_Page", "Main page")}
        });
    }

    @Parameterized.Parameter(0)
    public String line;

    @Parameterized.Parameter(1)
    public Pair<String> expected;

    @Test
    public void testDetect() {
        DetectHtmlLinks detector = new DetectHtmlLinks();
        Pair<String> actual = detector.detect(line);
        assertThat(actual, is(expected));
    }
}

package learn.hackerrank.regex;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DetectHtmlLinksSolutionTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        String input = "13\n" +
                "<div class=\"portal\" role=\"navigation\" id='p-navigation'>\n" +
                "<h3>Navigation</h3>\n" +
                "<div class=\"body\">\n" +
                "<ul>\n" +
                "<li id=\"n-mainpage-description\"><a href=\"/wiki/Main_Page\" title=\"Visit the main page [z]\" accesskey=\"z\">Main page</a></li>\n" +
                "<li id=\"n-contents\"><a href=\"/wiki/Portal:Contents\" title=\"Guides to browsing Wikipedia\">Contents</a></li>\n" +
                "<li id=\"n-featuredcontent\"><a href=\"/wiki/Portal:Featured_content\" title=\"Featured content  the best of Wikipedia\">Featured content</a></li>\n" +
                "<li id=\"n-currentevents\"><a href=\"/wiki/Portal:Current_events\" title=\"Find background information on current events\">Current events</a></li>\n" +
                "<li id=\"n-randompage\"><a href=\"/wiki/Special:Random\" title=\"Load a random article [x]\" accesskey=\"x\">Random article</a></li>\n" +
                "<li id=\"n-sitesupport\"><a href=\"//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&amp;utm_medium=sidebar&amp;utm_campaign=C13_en.wikipedia.org&amp;uselang=en\" title=\"Support us\">Donate to Wikipedia</a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        DetectHtmlLinksSolution.main(null);
        String expected = ""
                + "/wiki/Main_Page,Main page" + NL
                + "/wiki/Portal:Contents,Contents" + NL
                + "/wiki/Portal:Featured_content,Featured content" + NL
                + "/wiki/Portal:Current_events,Current events" + NL
                + "/wiki/Special:Random,Random article" + NL
                + "//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&amp;utm_medium=sidebar&amp;utm_campaign=C13_en.wikipedia.org&amp;uselang=en,Donate to Wikipedia" + NL
                + "";
        assertThat(buffer.toString(), Is.is(expected));
    }
}

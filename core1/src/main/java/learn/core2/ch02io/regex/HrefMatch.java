package learn.core2.ch02io.regex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Displays all URLs in a web page by matching a regular expression that describes
 * the {@code <a href=...>} HTML tag.
 * Usage: java HrefMatch URL
 */
public class HrefMatch {
    public static void main(String[] args) {
        String urlStr;
        if (args.length > 0) {
            urlStr = args[0];
        } else {
            urlStr = "http://greenteapress.com/thinkjava/";
//            urlStr = "http://horstmann.com";
        }
        try {
            InputStreamReader in = new InputStreamReader(new URL(urlStr).openStream(), StandardCharsets.UTF_8);
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
                builder.append((char) ch);
            }
            String patternStr = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s]*)\\s*>";
            Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(builder);
            while (matcher.find()) {
                String match = matcher.group();
                System.out.printf("%s  --  %s%n", match, matcher.group(1));
            }
        } catch (IOException | PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}

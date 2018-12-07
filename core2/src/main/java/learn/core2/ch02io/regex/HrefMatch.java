package learn.core2.ch02io.regex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatch {
    public static void main(String[] args) {
        String urlString;
        if (args.length > 0) {
            urlString = args[0];
        } else {
            urlString = "http://openjdk.java.net/projects/code-tools/jol/";
        }
        try (InputStreamReader in = new InputStreamReader(new URL(urlString).openStream())) {
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
                input.append((char) ch);
            }
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

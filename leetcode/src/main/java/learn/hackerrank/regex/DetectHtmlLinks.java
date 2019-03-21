package learn.hackerrank.regex;

import learn.hackerrank.common.Pair;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {
/*
    public static final String REGEX = "<a\\s+href=\"([^\"]+)\"(\\s+[^>]+)*>"
        + "(<\\w+>)*"  // excessive tags
        + "([^<>\"=]+)"
        + "(</\\w+>)*"  // excessive tags
        + "</a>";
*/
//    public static final String REGEX = "<a.+?href=\"(.+?)\".*?>(.+?)</a>";
    public static final String REGEX = "<a\\shref=\"([^\"]++)\"([^<>]*)>(<\\w+>)*([^<>]*)<";
    private Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);

    public Pair<String> detect(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return Pair.of(matcher.group(1), matcher.group(4).replaceAll("<.+?>", ""));
        }
        return Pair.empty();
    }

    private String regex2 = "<a\\s+href=\"([^\"]+)\"(\\s+[^>]+)*>(<\\w+>)*([^<]+)(</\\w+>)*</a>";
}

class DetectHtmlLinksSolution {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(DetectHtmlLinks.REGEX);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n > 0) {
            String line = in.nextLine();
            n--;
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                System.out.printf("%s,%s%n", m.group(1).trim(), m.group(4).replaceAll("<.+?>", "").trim());
            }
        }
    }
}
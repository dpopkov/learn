package learn.core2.ch02io.regex;

import java.util.regex.Matcher;

public class MatchedFormatter {
    private Matcher matcher;

    public MatchedFormatter(Matcher matcher) {
        this.matcher = matcher;
    }

    public String formatInGroups(String input) {
        StringBuilder builder = new StringBuilder();
        int g = matcher.groupCount();
        if (g > 0) {
            for (int i = 0; i < input.length(); i++) {
                for (int j = 1; j <= g; j++) {
                    if (i == matcher.start(j) && i == matcher.end(j)) {
                        builder.append("()");
                    }
                }
                for (int j = 1; j <= g; j++) {
                    if (i == matcher.start(j) && i != matcher.end(j)) {
                        builder.append("(");
                    }
                }
                builder.append(input.charAt(i));
                for (int j = 1; j <= g; j++) {
                    if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j)) {
                        builder.append(")");
                    }
                }
            }
        }
        return builder.toString();
    }
}

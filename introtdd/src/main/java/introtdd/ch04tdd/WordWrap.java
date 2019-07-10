package introtdd.ch04tdd;

import static java.lang.Math.*;

public class WordWrap {
    public static final String NL = System.lineSeparator();

    public static String wrap(String input, int lineLength) {
        int length = input.length();
        if (length < lineLength) {
            return input;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(input, 0, lineLength);
        int split = lineLength;
        while (split < length) {
            builder.append(NL);
            builder.append(input, split, min(split + lineLength, length));
            split += lineLength;
        }
        return builder.toString();
    }
}

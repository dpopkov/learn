package learn.hackerrank.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputStreamBuilder {
    private static final String NL = System.lineSeparator();

    private final StringBuilder stringBuilder = new StringBuilder();

    public void append(String s) {
        stringBuilder.append(s);
    }

    public void appendLn(String s) {
        stringBuilder.append(s);
        stringBuilder.append(NL);
    }


    public void append(int n) {
        stringBuilder.append(n);
    }

    public void appendLn(int n) {
        stringBuilder.append(n);
        stringBuilder.append(NL);
    }

    public void append(int[] numbers) {
        for (int n : numbers) {
            appendLn(n);
        }
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(stringBuilder.toString().getBytes());
    }
}

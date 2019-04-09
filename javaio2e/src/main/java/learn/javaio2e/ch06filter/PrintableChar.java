package learn.javaio2e.ch06filter;

public class PrintableChar {
    private PrintableChar() {}

    public static boolean is(int ch) {
        return 32 <= ch && ch <= 126 || ch == '\n' || ch == '\r' || ch == '\t';
    }
}

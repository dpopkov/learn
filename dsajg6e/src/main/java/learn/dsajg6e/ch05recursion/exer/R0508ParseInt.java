package learn.dsajg6e.ch05recursion.exer;

public class R0508ParseInt {
    public static int parseIntFrontToBack(String s) {
        int first = s.charAt(0) - '0';
        if (s.length() == 1) {
            return first;
        }
        String tailStr = s.substring(1);
        int tail = parseIntFrontToBack(tailStr);
        int multiplier = (int) Math.pow(10, s.length() - 1);
        return first * multiplier + tail;
    }

    public static int parseIntBackToFront(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }
        int last = s.length() - 1;
        String headStr = s.substring(0, last);
        int head = parseIntBackToFront(headStr);
        int lastDigit = s.charAt(last) - '0';
        return head * 10 + lastDigit;
    }
}

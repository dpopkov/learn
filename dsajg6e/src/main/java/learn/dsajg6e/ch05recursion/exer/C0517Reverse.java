package learn.dsajg6e.ch05recursion.exer;

public class C0517Reverse {
    static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}

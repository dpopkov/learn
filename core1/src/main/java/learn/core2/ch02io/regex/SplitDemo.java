package learn.core2.ch02io.regex;

import java.util.regex.Pattern;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "one, two.  three;four  :five!finish";
        String regex = "\\s*\\p{Punct}\\s*";
        System.out.println("input = " + input);
        System.out.println("regex = " + regex);
        Pattern p = Pattern.compile(regex);
        String[] tokens = p.split(input);
        for (String s : tokens) {
            System.out.println(s);
        }
    }
}

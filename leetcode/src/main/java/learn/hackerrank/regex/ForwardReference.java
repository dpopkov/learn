package learn.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Forward reference creates a back reference to a regex that would appear later.
 * Forward references are only useful if they're inside a repeated group.
 */
@SuppressWarnings("Annotator")
public class ForwardReference {
    public static void main(String[] args) {
        String regex = "(\\2amigo|\\3script|(go!)|(java!))+";
        Pattern pattern = Pattern.compile(regex);
        String[] tests = {"go!go!amigo", "java!script", "java!java!script", "go!", "java!"};
        for (String test : tests) {
            System.out.printf("\nProcessing '%s'%n", test);
            Matcher matcher = pattern.matcher(test);
            System.out.println("matcher.find(): " + matcher.find());
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.printf("Group %d: %s%n", i, matcher.group(i));
            }
        }
    }
}

class Solution {

    public static void main(String[] args) {

        Regex_Test tester = new Regex_Test();
//        tester.checker("^tac((tac)+tic(tac)*)(tic)?$"); // Use \\ instead of using \
        tester.checker("^(\\2tic|(tac))+$"); // Use \\ instead of using \

    }
}

class Regex_Test {

    public void checker(String Regex_Pattern){
        Scanner Input = new Scanner(System.in);
        String Test_String = Input.nextLine();
        Pattern p = Pattern.compile(Regex_Pattern);
        Matcher m = p.matcher(Test_String);
        System.out.println(m.find());
    }

}

package learn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String[] a = {"one", "two"};
        ArrayList<String> aa = new ArrayList<>();
        aa.add("one");
        aa.add("two");
        aa.forEach(e -> {
            System.out.println("element: " + e);
        });
    }
}

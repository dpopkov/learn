/* 20.6.6
Write a statement that sorts an ArrayList of strings named list in increasing
order of their last character.
 */
package learn.ijpds.ch20collections.checkpoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cp200606 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("ac");
        list.add("aaa");
        list.add("d");
        list.add("da");
        System.out.println(list);
//        list.sort((s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), s2.charAt(s2.length() - 1));
        list.sort(Comparator.comparingInt(v -> v.charAt(v.length() - 1)));
        System.out.println(list);
    }
}

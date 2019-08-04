package learn.dsajg6e.ch08trees.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * Разбивает строку на токены, каждый из которых представляет собой
 * либо строку без скобок, либо строку заключенную в сбалансированные скобки.
 */
public class ParenthesesSplitter {
    public List<String> split(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count == 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if (count == 0 && sb.length() > 0) {
            list.add(sb.toString());
        }
        return list;
    }
}

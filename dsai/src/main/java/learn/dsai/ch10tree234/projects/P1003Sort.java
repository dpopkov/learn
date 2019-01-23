package learn.dsai.ch10tree234.projects;

import java.util.List;

public class P1003Sort {
    public static void sort(List<Long> list) {
        P1002InOrder tree = new P1002InOrder();
        for (long v : list) {
            tree.insert(v);
        }
        list.clear();
        tree.inOrder(list::add);
    }
}

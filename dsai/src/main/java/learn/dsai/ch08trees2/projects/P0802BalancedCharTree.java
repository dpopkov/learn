package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.BTreeStringBuilder;
import learn.dsai.ch08trees2.TreeStringBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class P0802BalancedCharTree {
    private static final char PLUS = '+';

    private final CharNode root;
    private BTreeStringBuilder<Character> builder;

    public P0802BalancedCharTree(char[] chars) {
        Queue<CharNode> queue = new LinkedList<>();
        for (char ch : chars) {
            queue.add(new CharNode(ch));
        }
        while (queue.size() > 1) {
            CharNode p = new CharNode(PLUS);
            p.left = queue.remove();
            p.right = queue.remove();
            queue.add(p);
        }
        root = queue.remove();
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(1, false);
        }
        return builder.build(root);
    }
}

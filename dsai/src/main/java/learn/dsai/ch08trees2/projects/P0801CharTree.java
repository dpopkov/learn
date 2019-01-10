package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.BTreeStringBuilder;
import learn.dsai.ch08trees2.TreeStringBuilder;

public class P0801CharTree {
    private static final char PLUS = '+';

    private CharNode root;
    private BTreeStringBuilder<Character> builder;

    public P0801CharTree(char ch1, char ch2) {
        root = new CharNode(PLUS);
        root.left = new CharNode(ch1);
        root.right = new CharNode(ch2);
    }

    public void add(char ch) {
        CharNode newRoot = new CharNode(PLUS);
        newRoot.left = root;
        newRoot.right = new CharNode(ch);
        root = newRoot;
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(1, false);
        }
        return builder.build(root);
    }
}

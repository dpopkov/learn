package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.BTreeStringBuilder;
import learn.dsai.ch08trees2.TreeStringBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class P0803PyramidTree {
    private CharNode root;
    private int size;
    private final Queue<CharNode> parents = new LinkedList<>();
    private BTreeStringBuilder<Character> builder;

    public void add(char ch) {
        if (root == null) {
            root = new CharNode(ch);
            size = 1;
            parents.add(root);
        } else {
            if (parents.isEmpty()) {
                throw new IllegalStateException("Queue of parents is empty - this should not happen");
            }
            CharNode parent = parents.peek();
            CharNode node = new CharNode(ch);
            if (parent.left == null) {
                parent.left = node;
            } else if (parent.right == null) {
                parent.right = node;
                parents.add(parent.left);
                parents.add(parent.right);
                parents.remove();
            }
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(1, false);
        }
        return builder.build(root);
    }
}

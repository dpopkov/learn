package learn.dsai.ch08trees.projects;

import learn.dsai.ch08trees.BTreeNode;

public class NodeChar implements BTreeNode {
    final char character;
    NodeChar left;
    NodeChar right;

    public NodeChar(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return Character.toString(character);
    }

    @Override
    public BTreeNode getLeft() {
        return left;
    }

    @Override
    public BTreeNode getRight() {
        return right;
    }
}

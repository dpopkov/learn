package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.BNode;

class CharNode implements BNode<Character> {
    char character;
    CharNode left;
    CharNode right;

    public CharNode(char character) {
        this.character = character;
    }

    @Override
    public Character getData() {
        return character;
    }

    @Override
    public BNode<Character> getLeft() {
        return left;
    }

    @Override
    public BNode<Character> getRight() {
        return right;
    }
}

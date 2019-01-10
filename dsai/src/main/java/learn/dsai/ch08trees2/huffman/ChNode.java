package learn.dsai.ch08trees2.huffman;

public class ChNode implements Comparable<ChNode> {
    final char character;
    final int frequency;
    ChNode left;
    ChNode right;

    public ChNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(ChNode o) {
        return Integer.compare(this.frequency, o.frequency);
    }

    @Override
    public String toString() {
        return "ChNode{" + character + ':' + frequency + '}';
    }
}

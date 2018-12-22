package learn.dsai.ch08trees.projects;

public class NodeFreqChar extends NodeChar {
    private final int frequency;

    public NodeFreqChar(char character, int frequency) {
        super(character);
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + frequency;
    }
}

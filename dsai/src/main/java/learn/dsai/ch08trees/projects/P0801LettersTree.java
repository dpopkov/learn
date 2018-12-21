package learn.dsai.ch08trees.projects;

public class P0801LettersTree extends AbstractLettersTree {

    public P0801LettersTree(String s) {
        super(s);
    }

    @Override
    public void makeTree(NodeChar[] forest) {
        for (int i = 1; i < forest.length; i++) {
            NodeChar plus = new NodeChar('+');
            plus.left = forest[0];
            plus.right = forest[i];
            forest[0] = plus;
        }
    }
}

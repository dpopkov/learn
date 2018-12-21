package learn.dsai.ch08trees.projects;

public class P0802BalancedLettersTree extends AbstractLettersTree {

    public P0802BalancedLettersTree(String s) {
        super(s);
    }

    @Override
    public void makeTree(NodeChar[] forest) {
        int n = forest.length;
        while (n > 1) {
            for (int i = 0; i < n; i++) {
                NodeChar plus = new NodeChar('+');
                plus.left = forest[i];
                if (i + 1 < n) {
                    plus.right = forest[i + 1];
                    i++;
                }
                forest[i / 2] = plus;
            }
            n /= 2;
        }
    }
}

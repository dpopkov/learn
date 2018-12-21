package learn.dsai.ch08trees.projects;

public class P0803CompleteLettersTree extends AbstractLettersTree {

    public P0803CompleteLettersTree(String s) {
        super(s);
    }

    @Override
    public void makeTree(NodeChar[] forest) {
        fillNodes(forest[0], forest, 1);
    }

    /**
     * Fills tree of nodes starting from parent node and then
     * filling nodes level by level left to right.
     * @param parent parent node that get two sub-nodes
     * @param forest array of single valued nodes
     * @param nodeIdx index of node in the tree, with 1 at the root,
     *                2 at root.left, 3 at root.right
     */
    private void fillNodes(NodeChar parent, NodeChar[] forest, int nodeIdx) {
        int leftIdx = nodeIdx * 2 - 1;
        if (leftIdx >= forest.length) {
            return;
        }
        parent.left = forest[leftIdx];
        int rightIdx = leftIdx + 1;
        if (rightIdx >= forest.length) {
            return;
        }
        parent.right = forest[rightIdx];
        fillNodes(parent.left, forest, leftIdx + 1);
        fillNodes(parent.right, forest, rightIdx + 1);
    }
}

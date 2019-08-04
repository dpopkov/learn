package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.Tree;

import java.util.List;

/*
Describe an efficient algorithms for converting a fully balanced string of parentheses
into an equivalent tree.
The outermost pair of balanced parentheses is associated with the root
and each substring inside this pair, defined by the substring between two balanced
parentheses, is associated with a subtree of this root.
 */
public class C0827ParenthesesToTree {

    public static final String PARENTHESES_NODE = "()";

    Tree<String> convert(String s) {
        NTree<String> tree = new NTree<>();
        return convert(s, tree);
    }

    private Tree<String> convert(String s, NTree<String> tree) {
        tree.addRoot(PARENTHESES_NODE);
        if (inParentheses(s)) {
            s = strip(s);
        }
        convertStripped(s, tree, tree.root());
        return tree;
    }

    private void convertStripped(String stripped, NTree<String> tree, Position<String> parent) {
        List<String> tokens = new ParenthesesSplitter().split(stripped);
        for (String token : tokens) {
            if (inParentheses(token)) {
                Position<String> p = tree.add(parent, PARENTHESES_NODE);
                String s = strip(token);
                convertStripped(s, tree, p);
            } else {
                tree.add(parent, token);
            }
        }
    }

    private String strip(String s) {
        return s.substring(1, s.length() - 1);
    }

    private boolean inParentheses(String s) {
        return s.startsWith("(") && s.endsWith(")");
    }
}

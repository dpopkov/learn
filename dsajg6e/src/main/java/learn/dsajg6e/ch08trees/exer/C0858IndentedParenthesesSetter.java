package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.Tree;

import java.io.IOException;

public class C0858IndentedParenthesesSetter<E> {
    private static final String NL = System.lineSeparator();

    private final Tree<E> tree;
    private final int tabSize;

    public C0858IndentedParenthesesSetter(Tree<E> tree, int tabSize) {
        this.tree = tree;
        this.tabSize = tabSize;
    }

    public void parenthesize(Appendable out) throws IOException {
        parenthesize(tree.root(), out, 0);
    }

    private void parenthesize(Position<E> position, Appendable out, int indent) throws IOException {
        String indentation = " ".repeat(indent);
        out.append(indentation).append(position.getElement().toString());
        if (tree.isInternal(position)) {
            boolean first = true;
            for (Position<E> c : tree.children(position)) {
                if (first) {
                    out.append(" (");
                    first = false;
                }
                out.append(NL);
                parenthesize(c, out, indent + tabSize);
            }
            out.append(NL).append(indentation).append(")");
        }
    }
}

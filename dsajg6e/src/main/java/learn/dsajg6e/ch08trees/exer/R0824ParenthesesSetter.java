package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.Tree;

import java.io.IOException;

public class R0824ParenthesesSetter {
    private static final String NL = System.lineSeparator();

    private int currentWidth;

    public <E> void parenthesize(Tree<E> tree, Position<E> position, Appendable out) throws IOException {
        out.append(position.getElement().toString());
        if (tree.isInternal(position)) {
            boolean first = true;
            for (Position<E> c : tree.children(position)) {
                if (first) {
                    out.append(" (");
                    first = false;
                } else {
                    out.append(", ");
                }
                parenthesize(tree, c, out);
            }
            out.append(')');
        }
    }

    public <E> void parenthesize(Tree<E> tree, Position<E> position, Appendable out, int textWidth) throws IOException {
        currentWidth = 0;
        parenthesizeHelper(tree, position, out, textWidth);
    }

    private <E> void parenthesizeHelper(Tree<E> tree, Position<E> position, Appendable out, final int textWidth) throws IOException {
        String elementStr = position.getElement().toString();
        checkForLineBreakAndAddString(out, elementStr, textWidth);
        if (tree.isInternal(position)) {
            boolean first = true;
            for (Position<E> c : tree.children(position)) {
                if (first) {
                    checkForLineBreakAndAddString(out, " ", textWidth);
                    checkForLineBreakAndAddString(out, "(", textWidth);
                    first = false;
                } else {
                    checkForLineBreakAndAddString(out, ",", textWidth);
                    checkForLineBreakAndAddString(out, " ", textWidth);
                }
                parenthesizeHelper(tree, c, out, textWidth);
            }
            checkForLineBreakAndAddString(out, ")", textWidth);
        }
    }

    private void checkForLineBreakAndAddString(Appendable out, String s, int textWidth) throws IOException {
        if (currentWidth + s.length() > textWidth) {
            out.append(NL);
            currentWidth = 0;
        }
        if (currentWidth == 0 && s.equals(" ")) {
            return;
        }
        out.append(s);
        currentWidth += s.length();
    }
}

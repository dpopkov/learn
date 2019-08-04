package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.Tree;
import org.junit.Test;

import static learn.dsajg6e.ch08trees.exer.C0827ParenthesesToTree.PARENTHESES_NODE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class C0827ParenthesesToTreeTest {

    @Test
    public void whenConvertOneWordInParenthesesThenReturnWord() {
        var converter = new C0827ParenthesesToTree();
        Tree<String> result = converter.convert("(abc)");
        var root = result.root();
        var it = result.children(root).iterator();
        assertThat(root.getElement(), is(PARENTHESES_NODE));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getElement(), is("abc"));
    }

    @Test
    public void whenConvertNestedWordsInParenthesesThenReturnWords() {
        var converter = new C0827ParenthesesToTree();
        Tree<String> tree = converter.convert("((abc)(efg))");
        Position<String> root = tree.root();
        assertThat(root.getElement(), is(PARENTHESES_NODE));
        var it = tree.children(root).iterator();
        Position<String> p0 = it.next();
        assertThat(p0.getElement(), is(PARENTHESES_NODE));
        assertThat(tree.firstChild(p0), is("abc"));
        Position<String> p1 = it.next();
        assertThat(p1.getElement(), is(PARENTHESES_NODE));
        assertThat(tree.firstChild(p1), is("efg"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenConvertNestedTwoLevelsOfWordsInParenthesesThenReturnWords() {
        var converter = new C0827ParenthesesToTree();
        Tree<String> tree = converter.convert("(((abc)(efg))(hij))");

        Position<String> root = tree.root();
        assertThat(root.getElement(), is(PARENTHESES_NODE));

        var it = tree.children(root).iterator();
        var p0 = it.next();
        assertThat(p0.getElement(), is(PARENTHESES_NODE));
        var p1 = it.next();
        assertThat(p1.getElement(), is(PARENTHESES_NODE));
        assertThat(tree.firstChild(p1), is("hij"));
        assertThat(it.hasNext(), is(false));

        it = tree.children(p0).iterator();
        Position<String> p00 = it.next();
        assertThat(p00.getElement(), is(PARENTHESES_NODE));
        assertThat(tree.firstChild(p00), is("abc"));

        Position<String> p01 = it.next();
        assertThat(p01.getElement(), is(PARENTHESES_NODE));
        assertThat(tree.firstChild(p01), is("efg"));
        assertThat(it.hasNext(), is(false));
    }
}

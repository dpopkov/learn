package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0858IndentedParenthesesSetterTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testParenthesize() throws IOException {
        NTree<String> tree = new NTree<>();
        Position<String> root = tree.addRoot("Sales");
        tree.add(root, "Domestic");
        Position<String> right = tree.add(root, "International");
        tree.add(right, "Canada");
        tree.add(right, "S. America");
        right = tree.add(right, "Overseas");
        tree.add(right, "Africa");
        tree.add(right, "Europe");
        tree.add(right, "Asia");
        tree.add(right, "Australia");
        StringBuilder builder = new StringBuilder();
        new C0858IndentedParenthesesSetter<>(tree, 4).parenthesize(builder);
        String expected = String.join(NL,
                "Sales (",
                "    Domestic",
                "    International (",
                "        Canada",
                "        S. America",
                "        Overseas (",
                "            Africa",
                "            Europe",
                "            Asia",
                "            Australia",
                "        )",
                "    )",
                ")");
        assertThat(builder.toString(), is(expected));
    }
}

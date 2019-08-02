package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class R0815EulerTourTest {

    @Test
    public void testLevelNumber() {
        LinkedBinaryTree<IntElement> tree = LinkedBinaryTree.of(
                IntElement.zero(),
                IntElement.zero(),
                IntElement.zero(),
                IntElement.zero(),
                IntElement.zero(),
                IntElement.zero(),
                IntElement.zero()
        );
        new R0815EulerTour<IntElement>().levelNumber(tree);
        var it = tree.breadthFirst().iterator();
        int expected = 0;
        while (it.hasNext()) {
            IntElement element = it.next().getElement();
            assertThat(element.getInt(), is(expected));
            expected++;
        }
    }
}

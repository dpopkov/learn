package learn.dsai.ch10tree234.projects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P1004Tree23Test {

    @Test
    public void whenInsert2ValuesThenContains2Values() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        tree.insert(50);
        Node23<Integer> root = tree.getRoot();
        assertThat(root.getItem(0), is(50));
        tree.insert(30);
        assertThat(root.getItem(0), is(30));
        assertThat(root.getItem(1), is(50));
    }

    @Test
    public void whenInsert3ValuesThenSplitTo3Nodes() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        tree.insert(75);
        tree.insert(70);
        tree.insert(80);
        Node23<Integer> root = tree.getRoot();
        assertThat(root.getItem(0), is(75));
        assertThat(root.getNode(0).getItem(0), is(70));
        assertThat(root.getNode(1).getItem(0), is(80));
    }

    @Test
    public void whenInsert5ValuesThenSplitTo4Nodes() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        tree.insert(75, 70, 80, 90);

        Node23<Integer> root = tree.getRoot();
        assertThat(root.getItem(0), is(75));
        assertThat(root.getNode(0).getItem(0), is(70));
        assertThat(root.getNode(1).getItem(0), is(80));
        assertThat(root.getNode(1).getItem(1), is(90));

        tree.insert(85);
        root = tree.getRoot();
        assertThat(root.getItem(0), is(75));
        assertThat(root.getItem(1), is(85));
        assertThat(root.getNode(0).getItem(0), is(70));
        assertThat(root.getNode(1).getItem(0), is(80));
        assertThat(root.getNode(2).getItem(0), is(90));
    }

    @Test
    public void whenInsertToFullRootThenSplitAndMakeNewRoot() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        tree.insert(70, 75, 80, 85, 90, 95);
        Node23<Integer> root = tree.getRoot();
        assertThat(root.getItem(0), is(75));
        assertThat(root.getItem(1), is(85));
        assertThat(root.getNode(0).getItem(0), is(70));
        assertThat(root.getNode(1).getItem(0), is(80));
        assertThat(root.getNode(2).getItem(0), is(90));
        assertThat(root.getNode(2).getItem(1), is(95));
        tree.insert(99);
        root = tree.getRoot();
        assertThat(root.getItem(0), is(85));
        assertThat(root.getNode(0).getItem(0), is(75));
        assertThat(root.getNode(1).getItem(0), is(95));

        assertThat(root.getNode(0).getNode(0).getItem(0), is(70));
        assertThat(root.getNode(0).getNode(1).getItem(0), is(80));
        assertThat(root.getNode(1).getNode(0).getItem(0), is(90));
        assertThat(root.getNode(1).getNode(1).getItem(0), is(99));
    }

    @Test
    public void whenInsertReversedValuesThenSplitsCorrect() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        tree.insert(99, 95, 90, 85);
        Node23<Integer> root = tree.getRoot();
        assertThat(root.getItem(0), is(95));
        assertThat(root.getNode(0).getItem(0), is(85));
        assertThat(root.getNode(0).getItem(1), is(90));
        assertThat(root.getNode(1).getItem(0), is(99));
        tree.insert(80);
        root = tree.getRoot();
        assertThat(root.getItem(0), is(85));
        assertThat(root.getItem(1), is(95));
        assertThat(root.getNode(0).getItem(0), is(80));
        assertThat(root.getNode(1).getItem(0), is(90));
        assertThat(root.getNode(2).getItem(0), is(99));

        tree.insert(75);
        root = tree.getRoot();
        assertThat(root.getItem(0), is(85));
        assertThat(root.getItem(1), is(95));
        assertThat(root.getNode(0).getItem(0), is(75));
        assertThat(root.getNode(0).getItem(1), is(80));
        assertThat(root.getNode(1).getItem(0), is(90));
        assertThat(root.getNode(2).getItem(0), is(99));

        tree.insert(70);
        root = tree.getRoot();
        assertThat(root.getItem(0), is(85));
        assertThat(root.getNode(0).getItem(0), is(75));
        assertThat(root.getNode(1).getItem(0), is(95));
        assertThat(root.getNode(0).getNode(0).getItem(0), is(70));
        assertThat(root.getNode(0).getNode(1).getItem(0), is(80));
        assertThat(root.getNode(1).getNode(0).getItem(0), is(90));
        assertThat(root.getNode(1).getNode(1).getItem(0), is(99));
    }

    @Test
    public void testTraverseInOrder() {
        P1004Tree23<Integer> tree = new P1004Tree23<>();
        List<Integer> values = new ArrayList<>(List.of(70, 75, 80, 85, 90, 95, 99));
        Collections.reverse(values);
        tree.insert(values.toArray(new Integer[0]));
        assertThat(tree.toStringInOrder(), is("/70/75/80/85/90/99"));
    }
}

package learn.dsai.ch10tree234;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class Tree234Test {

    @Test
    public void whenFindInFirstNodeThenReturnsIndex() {
        Node n = new Node();
        n.insertItem(new DataItem(20));
        n.insertItem(new DataItem(10));
        Tree234 tree = new Tree234(n);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(20), is(1));
    }

    @Test
    public void whenFindInSecondNodeThenReturnsIndex() {
        Node n0 = new Node();
        n0.insertItem(new DataItem(20));
        Node n1 = new Node();
        n1.insertItem(new DataItem(10));
        Node n2 = new Node();
        n2.insertItem(new DataItem(30));
        n0.connect(0, n1);
        n0.connect(1, n2);
        Tree234 tree = new Tree234(n0);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(20), is(0));
        assertThat(tree.find(30), is(0));
    }

    @Test
    public void whenFindNonExistingThenReturnsMinusOne() {
        Node n = new Node();
        n.insertItem(new DataItem(10));
        Tree234 tree = new Tree234(n);
        assertThat(tree.find(30), is(-1));
    }

    @Test
    public void testInsert() {
        Tree234 tree = new Tree234();
        tree.insert(20);
        assertThat(tree.find(20), is(0));
        tree.insert(10);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(20), is(1));
        tree.insert(30);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(20), is(1));
        assertThat(tree.find(30), is(2));
        tree.insert(15);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(15), is(1));
        assertThat(tree.find(20), is(0));
        assertThat(tree.find(30), is(0));
        tree.insert(25);
        assertThat(tree.find(10), is(0));
        assertThat(tree.find(15), is(1));
        assertThat(tree.find(20), is(0));
        assertThat(tree.find(25), is(0));
        assertThat(tree.find(30), is(1));
        tree.insert(35);
        assertThat(tree.find(20), is(0));
        assertThat(tree.find(25), is(0));
        assertThat(tree.find(30), is(1));
        assertThat(tree.find(35), is(2));
        tree.insert(28);
        assertThat(tree.find(20), is(0));
        assertThat(tree.find(25), is(0));
        assertThat(tree.find(28), is(1));
        assertThat(tree.find(30), is(1));
        assertThat(tree.find(35), is(0));
    }

    @Test
    public void whenSplitRootThenCreatesThreeNodes() {
        Tree234 tree = new Tree234();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        Node root = tree.getRoot();
        tree.split(root);
        root = tree.getRoot();
        assertThat(root.findItem(20), is(0));
        assertThat(root.getNode(0).findItem(10), is(0));
        assertThat(root.getNode(1).findItem(30), is(0));
    }
}

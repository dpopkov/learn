package learn.dsai.ch10tree234;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testInsertItem() {
        Node node = new Node();
        int i = node.insertItem(new DataItem(10));
        assertThat(i, is(0));
        assertThat(node.getNumItems(), is(1));
        assertThat(node.getItem(0).getData(), is(10L));
        i = node.insertItem(new DataItem(5));
        assertThat(i, is(0));
        assertThat(node.getNumItems(), is(2));
        assertThat(node.getItem(0).getData(), is(5L));
        assertThat(node.getItem(1).getData(), is(10L));
        i = node.insertItem(new DataItem(7));
        assertThat(i, is(1));
        assertThat(node.getNumItems(), is(3));
        assertThat(node.getItem(0).getData(), is(5L));
        assertThat(node.getItem(1).getData(), is(7L));
        assertThat(node.getItem(2).getData(), is(10L));
    }

    @Test
    public void testRemoveItem() {
        Node node = new Node();
        node.insertItem(new DataItem(30));
        node.insertItem(new DataItem(10));
        node.insertItem(new DataItem(20));
        assertThat(node.removeItem().getData(), is(30L));
        assertThat(node.removeItem().getData(), is(20L));
        assertThat(node.removeItem().getData(), is(10L));
    }

    @Test
    public void whenInsertNodeThenInsertsInOrder() {
        Node n0 = Node.of(20L);
        n0.insert(Node.of(10L));
        assertThat(n0.getNode(0).toString(), is("/10/"));
        n0.insert(Node.of(30L));
        assertThat(n0.getNode(0).toString(), is("/10/"));
        assertThat(n0.getNode(1).toString(), is("/30/"));
    }

    @Test
    public void whenInsertNodeThenInsertsBetweenValues() {
        Node n0 = Node.of(10L, 20L, 30L);
        n0.insert(Node.of(5L));
        n0.insert(Node.of(25L));
        n0.insert(Node.of(35L));
        n0.insert(Node.of(15L));
        assertThat(n0.getNode(0).toString(), is("/5/"));
        assertThat(n0.getNode(1).toString(), is("/15/"));
        assertThat(n0.getNode(2).toString(), is("/25/"));
        assertThat(n0.getNode(3).toString(), is("/35/"));
    }
}

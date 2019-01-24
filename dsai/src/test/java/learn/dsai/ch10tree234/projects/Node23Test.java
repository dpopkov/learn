package learn.dsai.ch10tree234.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class Node23Test {

    @Test
    public void whenInsertSuccessiveThenInserted() {
        Node23<Integer> node = new Node23<>();
        node.insert(50);
        assertThat(node.getItem(0), is(50));
        node.insert(60);
        assertThat(node.getItem(0), is(50));
        assertThat(node.getItem(1), is(60));
    }

    @Test
    public void whenInsertInversedThenInserted() {
        Node23<Integer> node = new Node23<>();
        node.insert(60);
        assertThat(node.getItem(0), is(60));
        node.insert(50);
        assertThat(node.getItem(0), is(50));
        assertThat(node.getItem(1), is(60));
    }

    @Test
    public void whenConnectThenConnectedBeforeItem() {
        Node23<Integer> node = new Node23<>(75);
        Node23<Integer> subNode;
        subNode = new Node23<>(70);
        node.connect(subNode);
        assertThat(node.getNode(0).getItem(0), is(70));
        subNode = new Node23<>(80);
        node.connect(subNode);
        assertThat(node.getNode(0).getItem(0), is(70));
        assertThat(node.getNode(1).getItem(0), is(80));
    }
}
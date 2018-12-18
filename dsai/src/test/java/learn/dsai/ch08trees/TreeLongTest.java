package learn.dsai.ch08trees;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TreeLongTest {

    @Test
    public void testFind() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33});
        assertThat(tree.find(22).data, is(22L));
        assertNull(tree.find(10));
    }

    @Test
    public void testInsert() {
        TreeLong tree = new TreeLong();
        assertThat(tree.toString(), is("[]"));
        tree.insert(22);
        assertThat(tree.toString(), is("[22]"));
        tree.insert(11);
        tree.insert(33);
        assertThat(tree.toString(), is("[11, 22, 33]"));
    }

    @Test
    public void testMinimum() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33});
        assertThat(tree.minimum(), is(11L));
    }

    @Test
    public void testMaximum() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33});
        assertThat(tree.maximum(), is(33L));
    }

    @Test
    public void testDeleteLeaf() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33, 44});
        NodeLong deleted;
        deleted = tree.delete(44);
        assertNotNull(deleted);
        assertThat(deleted.data, is(44L));
        assertThat(tree.toString(), is("[11, 22, 33]"));
    }

    @Test
    public void testDeleteNodeWithRight() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33, 44});
        NodeLong deleted;
        deleted = tree.delete(33);
        assertNotNull(deleted);
        assertThat(deleted.data, is(33L));
        assertThat(tree.toString(), is("[11, 22, 44]"));
    }

    @Test
    public void testDeleteNodeWithLeft() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33, 32});
        NodeLong deleted;
        deleted = tree.delete(33);
        assertNotNull(deleted);
        assertThat(deleted.data, is(33L));
        assertThat(tree.toString(), is("[11, 22, 32]"));
    }

    @Test
    public void testFindRight() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33});
        NodeLong top = tree.find(22);
        NodeLong node = tree.findRight(top);
        assertThat(node.data, is(33L));
        tree.insert(32);
        assertThat(tree.findRight(top).data, is(33L));
        tree.insert(34);
        assertThat(tree.findRight(top).data, is(34L));
    }

    @Test
    public void testDeleteNodeWithLeftAndRight() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33, 32, 44});
        NodeLong deleted;
        deleted = tree.delete(33);
        assertNotNull(deleted);
        assertThat(deleted.data, is(33L));
        assertThat(tree.toString(), is("[11, 22, 32, 44]"));
    }

    @Ignore
    @Test
    public void testDeleteRoot() {
        TreeLong tree = new TreeLong();
        tree.insert(new long[] {22, 11, 33, 32, 44});
        NodeLong deleted;
        deleted = tree.delete(22);
        assertThat(deleted.data, is(22L));
        assertThat(tree.toString(), is("[11, 32, 33, 44]"));
    }
}

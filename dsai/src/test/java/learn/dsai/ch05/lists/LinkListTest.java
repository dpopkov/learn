package learn.dsai.ch05.lists;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkListTest {
    private LinkList list = new LinkList();

    @Test
    public void testInsertFirst() {
        list.insertFirst(11, 1.2);
        assertThat(list.toString(), is("{11, 1.2}"));
        list.insertFirst(22, 2.3);
        assertThat(list.toString(), is("{22, 2.3} {11, 1.2}"));
    }

    @Test
    public void testDeleteFirst() {
        list.insertFirst(11, 1.2);
        list.insertFirst(22, 2.3);
        assertThat(list.toString(), is("{22, 2.3} {11, 1.2}"));
        Link link;
        link = list.deleteFirst();
        assertThat(link.iData, is(22));
        link = list.deleteFirst();
        assertThat(link.iData, is(11));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void testFind() {
        list.insertFirst(11, 1.2);
        list.insertFirst(22, 2.3);
        Link link = list.find(22);
        assertThat(link.dData, is(2.3));
    }

    @Test
    public void testDelete() {
        list.insertFirst(11, 1.2);
        list.insertFirst(22, 2.3);
        list.insertFirst(33, 3.4);
        list.insertFirst(44, 4.5);
        Link link = list.delete(55);
        assertNull(link);
        assertThat(list.toString(), is("{44, 4.5} {33, 3.4} {22, 2.3} {11, 1.2}"));
        link = list.delete(33);
        assertThat(link.dData, is(3.4));
        assertThat(list.toString(), is("{44, 4.5} {22, 2.3} {11, 1.2}"));
        link = list.delete(44);
        assertThat(link.dData, is(4.5));
        assertThat(list.toString(), is("{22, 2.3} {11, 1.2}"));
        link = list.delete(11);
        assertThat(link.dData, is(1.2));
        assertThat(list.toString(), is("{22, 2.3}"));
        link = list.delete(22);
        assertThat(link.dData, is(2.3));
        assertThat(list.isEmpty(), is(true));
    }
}

package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0753MoveToFrontFavoritesTest {

    @Test
    public void accessedElementsAreAtFront() {
        C0753MoveToFrontFavorites<Integer> list = new C0753MoveToFrontFavorites<>(2);
        list.access(10);
        list.access(20);
        Iterator<Integer> it = list.getFavorites().iterator();
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(10));
    }

    @Test
    public void lastAccessedElementsAreMovedToFront() {
        C0753MoveToFrontFavorites<Integer> list = new C0753MoveToFrontFavorites<>(3);
        list.access(10);
        list.access(20);
        list.access(30);
        list.access(20);
        list.access(10);
        assertThat(list.size(), is(3));
        Iterator<Integer> it = list.getFavorites().iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(30));
    }

    @Test
    public void elementsNotAccessedInNAccessesArePurged() {
        C0753MoveToFrontFavorites<Integer> list = new C0753MoveToFrontFavorites<>(2);
        list.access(10);
        list.access(20);
        list.access(30);
        list.access(20);
        list.access(10);
        assertThat(list.size(), is(2));
        Iterator<Integer> it = list.getFavorites().iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        list.access(10);
        assertThat(list.size(), is(1));
        it = list.getFavorites().iterator();
        assertThat(it.next(), is(10));
    }
}

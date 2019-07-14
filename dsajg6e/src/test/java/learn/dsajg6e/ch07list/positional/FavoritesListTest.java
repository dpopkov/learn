package learn.dsajg6e.ch07list.positional;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class FavoritesListTest {
    @Test
    public void whenAccessNewElementsThenAddElementsToList() {
        FavoritesList<Integer> list = new FavoritesList<>();
        list.access(10);
        list.access(20);
        Iterator<Integer> it = list.getFavorites(2).iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
    }

    @Test
    public void whenAccessOldElementThenPlaceElementByAccessCount() {
        FavoritesList<Integer> list = new FavoritesList<>();
        list.access(10);
        list.access(20);
        list.access(30);
        list.access(20);
        assertThat(list.size(), is(3));
        Iterator<Integer> it = list.getFavorites(3).iterator();
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
    }

    @Test
    public void whenRemoveThenRemoved() {
        FavoritesList<Integer> list = new FavoritesList<>();
        list.access(10);
        list.access(20);
        list.access(30);
        list.remove(20);
        Iterator<Integer> it = list.getFavorites(2).iterator();
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(30));
        list.remove(10);
        list.remove(30);
        assertThat(list.isEmpty(), is(true));
    }
}

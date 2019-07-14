package learn.dsajg6e.ch07list.positional;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FavoritesListMTFTest {
    @Test
    public void whenAccessNewElementsThenAddElementsToList() {
        FavoritesListMTF<Integer> list = new FavoritesListMTF<>();
        list.access(10);
        list.access(20);
        Iterator<Integer> it = list.getFavorites(2).iterator();
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(10));
    }

    @Test
    public void whenGetFavoritesThenReturnMostAccessed() {
        FavoritesListMTF<Integer> list = new FavoritesListMTF<>();
        list.access(10);
        list.access(20);
        list.access(30);
        list.access(20);
        list.access(30);
        list.access(20);
        list.access(40);
        assertThat(list.size(), is(4));
        Iterator<Integer> it = list.getFavorites(2).iterator();
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(30));
    }
}

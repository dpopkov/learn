package learn.dsajg6e.ch09pq2.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0951FavoritesListTest {

    @Test
    public void testGetFavorites() {
        P0951FavoritesList<Integer> list = new P0951FavoritesList<>();
        Integer i10 = 10;
        Integer i20 = 20;
        Integer i30 = 30;
        list.access(i10);
        list.access(i20);
        list.access(i10);
        list.access(i30);    // 3
        list.access(i10);
        list.access(i30);
        list.access(i20);    // 2
        list.access(i30);
        list.access(i10);    // 5
        Iterable<Integer> result = list.getFavorites(2);
        assertThat(result, containsInAnyOrder(i10, i30));
        assertThat(result, not(contains(i20)));
    }
}

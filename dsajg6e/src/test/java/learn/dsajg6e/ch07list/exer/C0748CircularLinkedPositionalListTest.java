package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.CircularPositionalList;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0748CircularLinkedPositionalListTest {

    /* C-7.49 */
    @Test
    public void whenRotateThenFirstElementGoesToTheEnd() {
        C0748CircularLinkedPositionalList<Integer> list = new C0748CircularLinkedPositionalList<>();
        list.addLast(10);
        list.addLast(20);
        assertThat(list.first().getElement(), is(10));
        assertThat(list.toString(), is("[10, 20]"));
        ((CircularPositionalList<Integer>) list).rotate();
        assertThat(list.first().getElement(), is(20));
        assertThat(list.toString(), is("[20, 10]"));
    }
}

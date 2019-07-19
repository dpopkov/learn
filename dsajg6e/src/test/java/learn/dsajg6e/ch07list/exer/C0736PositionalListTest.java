package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0736PositionalListTest {

    @Test
    public void whenFindingPositionAtIndexThenReturnsPosition() {
        C0736PositionalList<Integer> list = new C0736PositionalList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertThat(list.positionAtIndex(0).getElement(), is(10));
        assertThat(list.positionAtIndex(1).getElement(), is(20));
        assertThat(list.positionAtIndex(2).getElement(), is(30));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenFindingPositionBeyondLengthThenException() {
        C0736PositionalList<Integer> list = new C0736PositionalList<>();
        list.addLast(10);
        list.positionAtIndex(1);
    }
}

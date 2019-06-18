package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0329SameSequenceTest {

    @Test
    public void testHasSameElementsAs() {
        var list1 = new C0329SameSequence<Integer>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        var list2 = new C0329SameSequence<Integer>();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        assertThat(list1.hasSameElementsAs(list2), is(true));
        list2.addLast(4);
        assertThat(list1.hasSameElementsAs(list2), is(false));
        list1.addLast(44);
        assertThat(list1.hasSameElementsAs(list2), is(false));
    }

    @Test
    public void testHasSameElementsWhenHaveDifferentStartingPoints() {
        var list1 = new C0329SameSequence<Integer>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        var list2 = new C0329SameSequence<Integer>();
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(1);
        assertThat(list1.hasSameElementsAs(list2), is(true));
        list2.rotate(); // 3 1 2
        assertThat(list1.hasSameElementsAs(list2), is(true));
        list2.rotate(); // 1 2 3
        assertThat(list1.hasSameElementsAs(list2), is(true));
        list1.addFirst(44); // 44 1 2 3
        list2.addFirst(4);  // 4 1 2 3
        assertThat(list1.hasSameElementsAs(list2), is(false));
        list1.rotate();         // 1 2 3 44
        list2.addLast(44);   // 4 1 2 3 44
        assertThat(list1.hasSameElementsAs(list2), is(false));
        list1.addLast(4);  // 1 2 3 44 4
        assertThat(list1.hasSameElementsAs(list2), is(true));
    }
}

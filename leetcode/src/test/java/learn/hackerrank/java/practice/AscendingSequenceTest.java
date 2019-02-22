package learn.hackerrank.java.practice;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class AscendingSequenceTest {

    @Test
    public void whenFindInMiddleThenGetsSequence() {
        int[] numbers = {3, 2, 1, 2, 1};
        AscendingSequence seq = new AscendingSequence();
        seq.find(numbers);
        assertThat(seq.getStart(), is(2));
        assertThat(seq.getEnd(), is(3));
    }

    @Test
    public void whenFindAtStartThenGetsSequence() {
        int[] numbers = {3, 4, 5, 2, 1, 2, 1};
        AscendingSequence seq = new AscendingSequence();
        seq.find(numbers);
        assertThat(seq.getStart(), is(0));
        assertThat(seq.getEnd(), is(2));
    }

    @Test
    public void whenFindAtEndThenGetsSequence() {
        int[] numbers = {3, 2, 1, 2, 1, 3, 4, 5};
        AscendingSequence seq = new AscendingSequence();
        seq.find(numbers);
        assertThat(seq.getStart(), is(4));
        assertThat(seq.getEnd(), is(7));
    }

    @Test
    public void whenTwoAscendingItemsThenReturns0and1() {
        AscendingSequence seq = new AscendingSequence();
        seq.find(new int[]{3, 4});
        assertThat(seq.getStart(), is(0));
        assertThat(seq.getEnd(), is(1));
    }

    @Test
    public void whenTwoDescendingItemsThenReturns1() {
        AscendingSequence seq = new AscendingSequence();
        seq.find(new int[]{3, -4});
        assertThat(seq.getStart(), is(1));
        assertThat(seq.getEnd(), is(1));
    }
}

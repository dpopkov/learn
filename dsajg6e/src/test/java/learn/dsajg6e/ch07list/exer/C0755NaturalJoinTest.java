package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.exer.C0755NaturalJoin.Pair;
import learn.dsajg6e.ch07list.exer.C0755NaturalJoin.Triple;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class C0755NaturalJoinTest {

    @Test
    public void canDoNaturalJoin() {
        List<Pair<Integer>> left = Arrays.asList(
                new Pair<>(15, 15),
                new Pair<>(10, 1),
                new Pair<>(20, 2)
        );
        List<Pair<Integer>> right = Arrays.asList(
                new Pair<>(12, 12),
                new Pair<>(2, 200),
                new Pair<>(1, 100),
                new Pair<>(4, 40)
        );
        List<Triple<Integer>> result = new C0755NaturalJoin<Integer>().naturalJoin(left, right);
        assertThat(result, Matchers.is(Arrays.asList(
                new Triple<>(10, 1, 100),
                new Triple<>(20, 2, 200)
        )));
    }
}

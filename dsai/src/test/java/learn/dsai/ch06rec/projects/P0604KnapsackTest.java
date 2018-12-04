package learn.dsai.ch06rec.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0604KnapsackTest {
    private P0604Knapsack sack = new P0604Knapsack();

    @Test
    public void testKnapsackSimpleSum() {
        int[] weights = {11, 7, 5, 3};
        boolean r = sack.addToWeight(23, weights, 0);
        assertThat(r, is(true));
        assertThat(sack.getWeight(), is(23));
    }

    @Test
    public void testKnapsack() {
        int[] weights = {16, 15, 14, 12, 11, 10, 8, 7, 5};
        boolean r = sack.addToWeight(18, weights, 0);
        assertThat(r, is(true));
        assertThat(sack.getWeight(), is(18));
        System.out.println("knapsack: " + sack.toString());
    }
}

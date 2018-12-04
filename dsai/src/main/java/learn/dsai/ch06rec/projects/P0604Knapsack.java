package learn.dsai.ch06rec.projects;

import java.util.ArrayList;
import java.util.List;

/*
Write a program that solves the knapsack problem for an arbitrary
knapsack capacity and series of weights.
Assume the weights are stored in an array.
Hint: The arguments to the recursive knapsack() function are
the target weight and the array index where the remaining items
start.
 */
public class P0604Knapsack {
    private List<Integer> sack = new ArrayList<>();

    public int getWeight() {
        return sack.stream().reduce(0, (x, y) -> x + y);
    }

    public boolean addToWeight(int targetWeight, int[] weights, int index) {
        if (targetWeight == 0) {
            return true;
        }
        if (targetWeight < 0 || index >= weights.length) {
            return false;
        }
        int current = weights[index++];
        while (current > targetWeight && index < weights.length) {
            current = weights[index++];
        }
        if (current == targetWeight) {
            sack.add(current);
            return true;
        } else if (index == weights.length) {
            return false;
        }
        // post-condition: current < targetWeight
        sack.add(current);
        boolean rst = addToWeight(targetWeight - current, weights, index);
        if (rst) {
            return true;
        } else {
            sack.remove(sack.size() - 1);
            return addToWeight(targetWeight, weights, index + 1);
        }
    }

    @Override
    public String toString() {
        return sack.toString();
    }

    public static void main(String[] args) {

    }
}

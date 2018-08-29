package learn.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice
 */
public class TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] r = new int[2];
        for (int i = 0;  i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    public int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i];
            if (numberToIndex.containsKey(complement)
                    && numberToIndex.get(complement) != i) {
                return new int[] {i, numberToIndex.get(complement)};
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}

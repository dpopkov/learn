package learn.leetcode.arrays;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:<br>
 * The solution set must not contain duplicate triplets.<br>
 * Example:<br>
 * <pre>{@code
 *     Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * }</pre>
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<List<Integer>> set = new LinkedHashSet<>();
        List<Integer> triplet;
        Integer candidate;
        int foundIndex, a, b;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                a = nums[i];
                b = nums[j];
                int compliment = -(a + b);
                candidate = map.get(compliment);
                if (candidate != null) {
                    foundIndex = candidate;
                    if (foundIndex != i && foundIndex != j) {
                        triplet = Arrays.asList(a, b, nums[foundIndex]);
                        triplet.sort(Comparator.naturalOrder());
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}

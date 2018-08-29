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
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        List<Integer> li = new ArrayList<>();
        li.addAll(s);
        return r;
    }
}
/*
java.lang.AssertionError:
Expected: is <[[-1, 0, 1], [-1, -1, 2]]>
     but: was <[[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]>
Expected :is <[[-1, 0, 1], [-1, -1, 2]]>

Actual   :<[[-1, 0, 1], [-1, 2, -1], [0, 1, -1]]>
 */


/*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return r;
    }

 */
package algorithm.leetcode.problem_5953;

import java.util.HashSet;

public class Solution {
    public long subArrayRanges(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        HashSet<String> set = new HashSet<>();
        return process(0, 0, nums, set);
    }

    public long process(int beg, int end, int[] nums, HashSet<String> set) {
        if (beg > end || end >= nums.length || set.contains(beg + "" + end)) {
            return 0;
        }
        set.add(beg + "" + end);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = beg; i <= end; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        System.out.printf("%d, %d, %d\n", beg, end, max - min);
        return max - min + process(beg + 1, end, nums, set) + process(beg, end + 1, nums, set);
    }
}

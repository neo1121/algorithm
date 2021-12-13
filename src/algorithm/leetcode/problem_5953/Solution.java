package algorithm.leetcode.problem_5953;

public class Solution {
    public long subArrayRanges(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }
            ret += max - min;
        }
        return ret;
    }

    public long process(int beg, int end, int[] nums) {
        if (beg > end || end >= nums.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = beg; i <= end; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min + process(beg, end + 1, nums);
    }
}

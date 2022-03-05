package algorithm.leetcode.problem_53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}

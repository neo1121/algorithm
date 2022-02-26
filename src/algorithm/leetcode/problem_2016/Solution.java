package algorithm.leetcode.problem_2016;

public class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return ans;
    }
}

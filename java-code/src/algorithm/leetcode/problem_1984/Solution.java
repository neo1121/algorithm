package algorithm.leetcode.problem_1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

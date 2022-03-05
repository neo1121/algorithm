package algorithm.leetcode.problem_152;

public class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}

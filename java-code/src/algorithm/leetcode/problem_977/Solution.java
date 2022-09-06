package algorithm.leetcode.problem_977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int[] ans = new int[n];
        int idx = n - 1;
        while (l <= r) {
            int l2 = nums[l] * nums[l];
            int r2 = nums[r] * nums[r];
            if (l2 > r2) {
                ans[idx--] = l2;
                l += 1;
            } else {
                ans[idx--] = r2;
                r -= 1;
            }
        }
        return ans;
    }
}

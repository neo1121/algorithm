package algorithm.leetcode.problem_486;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int p1 = f(nums, 0, nums.length - 1);
        int p2 = s(nums, 0, nums.length - 1);
        return p1 >= p2;
    }

    // 先手
    public int f(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        return Math.max(nums[l] + s(nums, l + 1, r), nums[r] + s(nums, l, r - 1));
    }

    // 后手
    public int s(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(f(nums, l + 1, r), f(nums, l, r - 1));
    }
}

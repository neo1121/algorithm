package algorithm.leetcode.problem_704;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int m = nums.length / 2;
        int r = nums.length - 1;
        while (nums[m] != target) {
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + (r - l) / 2;
            if (m < l || m > r)
                return -1;
        }
        if (nums[m] != target) return -1;
        return m;
    }
}

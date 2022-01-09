package algorithm.leetcode.problem_35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    public int find(int[] nums, int target, int l, int r) {
        if (l == r) {
            if (nums[l] >= target) {
                return l;
            } else if (nums[l] < target) {
                return l + 1;
            }
        }
        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return find(nums, target, m + 1, r);
        } else {
            return find(nums, target, l, m);
        }
    }
}

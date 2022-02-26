package algorithm.leetcode.problem_34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = find(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int l = index;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            l = i;
        }
        int r = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            r = i;
        }
        return new int[]{l, r};
    }

    public int find(int[] nums, int l, int r, int tar) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return nums[l] == tar ? l : -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] == tar) {
            return m;
        } else if (nums[m] > tar) {
            return find(nums, l, m - 1, tar);
        } else {
            return find(nums, m + 1, r, tar);
        }
    }
}

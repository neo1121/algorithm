package algorithm.leetcode.problem_33;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < nums.length && nums[l] > target) {
            l += 1;
        }
        while (r >= 0 && nums[r] < target) {
            r -= 1;
        }
        return binarySearch(nums, l, r, target);
    }

    public int binarySearch(int[] nums, int l, int r, int tar) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (nums[m] < tar) {
            return binarySearch(nums, m + 1, r, tar);
        } else if (nums[m] > tar) {
            return binarySearch(nums, l, m - 1, tar);
        } else {
            return m;
        }
    }
}

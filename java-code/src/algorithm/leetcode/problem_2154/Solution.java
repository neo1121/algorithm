package algorithm.leetcode.problem_2154;

import java.util.Arrays;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            l = find(nums, original, l, r);
            if (l != -1) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }

    public int find(int[] nums, int tar, int l, int r) {
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
            return find(nums, tar, l, m - 1);
        } else {
            return find(nums, tar, m + 1, r);
        }
    }
}

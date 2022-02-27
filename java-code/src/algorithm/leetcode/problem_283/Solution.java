package algorithm.leetcode.problem_283;

public class Solution {
    public void moveZeroes(int[] nums) {
        for (
                int zeroIndex = 0, nonZeroIndex = 0;
                zeroIndex < nums.length && nonZeroIndex < nums.length;
                nonZeroIndex++
        ) {
            if (nums[nonZeroIndex] != 0) {
                swap(nums, zeroIndex++, nonZeroIndex);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

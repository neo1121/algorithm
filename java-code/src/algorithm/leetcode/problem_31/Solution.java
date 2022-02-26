package algorithm.leetcode.problem_31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
        if (i == -1) {
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        for (; j > i && nums[j] <= nums[i]; j--) ;
        swap(nums, i, j);
        Arrays.sort(nums, i + 1, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

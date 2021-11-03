package algorithm.leetcode.problem_912.insertSort;

import java.util.Arrays;

// overtime
// stable
public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        insertSort(nums);
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 0, 4, 7};
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
}

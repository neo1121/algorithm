package algorithm.leetcode.problem_912.bubbleSort;

import java.util.Arrays;

// overtime
// stable
public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        bubbleSort(nums);
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 0, 4, 7};
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
}

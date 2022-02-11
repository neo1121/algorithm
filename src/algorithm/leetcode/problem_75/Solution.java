package algorithm.leetcode.problem_75;

public class Solution {
    public void sortColors(int[] nums) {
        int l = -1;
        int r = nums.length;
        for (int i = 0; i < r; ) {
            if (nums[i] == 1) {
                i += 1;
            } else if (nums[i] == 0) {
                swap(nums, i++, ++l);
            } else if (nums[i] == 2) {
                swap(nums, i, --r);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

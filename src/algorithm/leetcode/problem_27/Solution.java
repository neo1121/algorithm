package algorithm.leetcode.problem_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int ret = 0;
        for (int i = 0; i < nums.length - ret; ) {
            if (nums[i] == val) {
                swap(nums, i, last);
                last -= 1;
                ret += 1;
            } else {
                i += 1;
            }
        }
        return nums.length - ret;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

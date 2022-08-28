package algorithm.leetcode.problem_912.selectionSort;

// overtime
// non-stable
public class Solution {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        selectionSort(nums);
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getMin(int[] nums, int l, int r) {
        if (l >= r) return r;
        int m = l + (r - l) / 2;
        int leftMax = getMin(nums, l, m);
        int rightMax = getMin(nums, m + 1, r);
        return nums[leftMax] < nums[rightMax] ? leftMax : rightMax;
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = getMin(nums, i, nums.length - 1);
            swap(nums, i, minIndex);
        }
    }
}

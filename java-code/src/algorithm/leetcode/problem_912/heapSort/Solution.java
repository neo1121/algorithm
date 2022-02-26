package algorithm.leetcode.problem_912.heapSort;

import java.util.Arrays;

// non-stable
public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        while (heapSize > 1) {
            swap(nums, 0, --heapSize);
            heapify(nums, 0, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // move up
    public void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1)/2]) {
            swap(nums, i, (i - 1)/2);
            i = (i - 1)/2;
        }
    }

    // move downward
    public void heapify(int[] nums, int i, int heapSize) {
        while (i < heapSize) {
            int left = i * 2 + 1;
            if (left >= heapSize) break;
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            if (nums[i] > nums[largest])
                break;
            swap(nums, i, largest);
            i = largest;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 4, 7};
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
}

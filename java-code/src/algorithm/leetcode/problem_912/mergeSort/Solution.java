package algorithm.leetcode.problem_912.mergeSort;

// stability depends on the code
public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        return process(nums, 0, nums.length - 1);
    }

    public int[] process(int[] nums, int l, int r) {
        if (l == r) return nums;
        int m = l + ((r - l) >> 1);
        process(nums, l, m);
        process(nums, m + 1, r);
        merge(nums, l, m, r);
        return nums;
    }

    public void merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }
}

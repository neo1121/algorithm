package algorithm.leetcode.problem_215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums);
        return nums[nums.length - k];
    }

    public void mergeSort(int[] nums) {
        process(nums, 0, nums.length - 1);
    }

    public void process(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        process(nums, l, m);
        process(nums, m + 1, r);
        merge(nums, l, r, m);
    }

    public void merge(int[] nums, int l, int r, int m) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                help[index++] = nums[i++];
            } else {
                help[index++] = nums[j++];
            }
        }
        while (i <= m) {
            help[index++] = nums[i++];
        }
        while (j <= r) {
            help[index++] = nums[j++];
        }
        System.arraycopy(help, 0, nums, l, r - l + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

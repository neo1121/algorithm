package algorithm.leetcode.problem_912.quicksort;

// non-stable
public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        // avoids the worst case
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        quickSort(nums, l, p[0]);
        quickSort(nums, p[1], r);
    }

    public int[] partition(int[] nums, int l, int r) {
        // points to the current position
        int i = l;
        // points to the rightmost side of the less part
        int less = l - 1;
        // points to the leftmost side of the more part
        int more = r;
        while (i < more) {
            if (nums[i] < nums[r])
                swap(nums, i++, ++less);
            else if (nums[i] > nums[r])
                swap(nums, i, --more);
            else i++;
        }
        swap(nums, more, r);
        return new int[]{less, more};
    }
}

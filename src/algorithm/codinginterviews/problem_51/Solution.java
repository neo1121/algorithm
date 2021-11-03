package algorithm.codinginterviews.problem_51;

public class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length == 0)
            return 0;
        return process(nums, 0, nums.length - 1);
    }

    public int process(int[] nums, int l, int r) {
        if (l == r)
            return 0;
        int m = l + ((r - l) >> 1);
        return process(nums, l, m) + process(nums, m + 1, r) + merge(nums, l, m, r);
    }

    public int merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int count = 0;
        // points to the leftmost side of the left part
        int p1 = l;
        // points to the leftmost side of the right part
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            count += nums[p1] > nums[p2] ? r - p2 + 1 : 0;
            help[i++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
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
        return count;
    }

    // for test
    public static void main(String[] args) {
        int[] nums = {5, 7, 6, 4};
        System.out.println(new Solution().reversePairs(nums));
    }
}

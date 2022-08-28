package algorithm.leetcode.problem_912.radixSort;

// stable
public class Solution {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        radixSort(nums, 0, nums.length - 1, 10);
        return nums;
    }

    public int pretreat(int[] nums) {
        // pretreatment avoids the array contains negative numbers
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        if (min >= 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        return min;
    }

    public int maxBit(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);
        int count = 0;
        while (max > 0) {
            count++;
            max /= 10;
        }
        return count;
    }

    public int getDigit(int num, int p) {
        return (int) (num / Math.pow(10, p - 1) % 10);
    }

    public void radixSort(int[] nums, int l, int r, int radix) {
        int[] help = new int[r - l + 1];
        int difference = pretreat(nums);
        int maxBit = maxBit(nums);
        for (int i = 1; i <= maxBit; i++) {
            int[] count = new int[radix];
            for (int num : nums) {
                count[getDigit(num, i)]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }
//            for (int j = r; j >= l; j--) {
//                int p = --count[getDigit(nums[j], i)];
//                help[p] = nums[j];
//            }
            for (int j = l; j <= r; j++) {
                int p = --count[getDigit(nums[j], i)];
                help[p] = nums[j];
            }
            System.arraycopy(help, 0, nums, 0, nums.length);
        }
        if (difference < 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] += difference;
            }
        }
    }
}

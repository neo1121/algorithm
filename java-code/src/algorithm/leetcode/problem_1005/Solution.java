package algorithm.leetcode.problem_1005;

import java.util.Arrays;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            if (nums[i % nums.length] >= 0) {
                if ((k - i) % 2 != 0) {
                    Arrays.sort(nums);
                    nums[0] *= -1;
                }
                break;
            }
            nums[i % nums.length] *= -1;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

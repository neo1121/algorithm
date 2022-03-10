package algorithm.leetcode.problem_2195;

import java.util.Arrays;

public class Solution {
    public long[] calc(long small, long big, int k) {
        if (small > big) {
            return new long[]{0, 0};
        }
        big = Math.min(small + k - 1, big);
        return new long[]{(small + big) * (big - small + 1) / 2, big - small + 1};
    }

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long[] calcAns = calc(1, nums[0] - 1, k);
        long ans = calcAns[0];
        k -= calcAns[1];
        for (int i = 1; i < nums.length && k > 0; i++) {
            calcAns = calc(nums[i - 1] + 1, nums[i] - 1, k);
            ans += calcAns[0];
            k -= calcAns[1];
        }
        if (k > 0) {
            calcAns = calc(nums[nums.length - 1] + 1, Long.MAX_VALUE, k);
            ans += calcAns[0];
        }
        return ans;
    }
}

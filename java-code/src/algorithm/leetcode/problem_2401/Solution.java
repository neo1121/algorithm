package algorithm.leetcode.problem_2401;

public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (left < n && right < n) {
            boolean isNice = true;

            for (int i = right - 1; i >= left; i--) {
                if ((nums[right] & nums[i]) != 0) {
                    isNice = false;
                    left = i + 1;
                    break;
                }
            }

            if (isNice) {
                ans = Math.max(ans, right - left + 1);
            }
            right += 1;
        }
        return ans;
    }
}

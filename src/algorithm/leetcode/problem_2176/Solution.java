package algorithm.leetcode.problem_2176;

public class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}

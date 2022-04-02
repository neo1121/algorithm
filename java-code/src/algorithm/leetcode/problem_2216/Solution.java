package algorithm.leetcode.problem_2216;

public class Solution {
    public int minDeletion(int[] nums) {
        boolean f = false;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                continue;
            }
            if (!f && i % 2 == 0) {
                ans += 1;
                f = true;
            } else if (f && i % 2 == 1) {
                ans += 1;
                f = false;
            }
        }
        if ((nums.length - ans) % 2 == 1) {
            ans += 1;
        }
        return ans;
    }
}

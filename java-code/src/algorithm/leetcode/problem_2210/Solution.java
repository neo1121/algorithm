package algorithm.leetcode.problem_2210;

public class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; ) {
            boolean f = false;
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                f = nums[i] > nums[j];
                break;
            }
            if (j < 0) {
                i += 1;
                continue;
            }
            j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                if (f && nums[i] > nums[j]) {
                    ans += 1;
                } else if (!f && nums[i] < nums[j]) {
                    ans += 1;
                }
                break;
            }
            i = j;
        }
        return ans;
    }
}

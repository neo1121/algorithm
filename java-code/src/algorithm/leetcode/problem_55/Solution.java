package algorithm.leetcode.problem_55;

public class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest >= nums.length - 1) {
                return true;
            } else if (i <= farthest) {
                farthest = Math.max(farthest, i + nums[i]);
            } else {
                break;
            }
        }
        return false;
    }
}

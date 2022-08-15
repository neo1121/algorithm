package algorithm.leetcode.problem_45;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int far = nums[0];
        int ans = 1;
        int i = 0;
        while (far < nums.length - 1) {
            int max = i;
            while (i <= far) {
                max = Math.max(max, i + nums[i]);
                i += 1;
            }
            // System.out.println(far+" "+max);
            far = max;
            ans += 1;
        }
        return ans;
    }
}

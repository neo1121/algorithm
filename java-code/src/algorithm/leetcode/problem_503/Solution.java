package algorithm.leetcode.problem_503;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (top > -1 && stack[top] <= nums[i % n]) {
                top -= 1;
            }
            if (top > -1) {
                ans[i % n] = stack[top];
            } else {
                ans[i % n] = -1;
            }
            stack[++top] = nums[i % n];
        }
        return ans;
    }

}

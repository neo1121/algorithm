package algorithm.leetcode.problem_581;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] stack = new int[nums.length];
        int top = -1;
        int left = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (top > -1 && nums[stack[top]] > nums[i]) {
                left = Math.min(left, stack[top--]);
            }
            stack[++top] = i;
        }
        top = -1;
        int right = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (top > -1 && nums[stack[top]] < nums[i]) {
                right = Math.max(right, stack[top--]);
            }
            stack[++top] = i;
        }
        if (right < left) {
            return 0;
        }
        return right - left + 1;
    }
}

package algorithm.leetcode.problem_739;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[stack[top]] < temperatures[i]) {
                ans[stack[top]] = i - stack[top];
                top -= 1;
            }
            stack[++top] = i;
        }
        while (top > -1) {
            ans[stack[top--]] = 0;
        }
        return ans;
    }
}

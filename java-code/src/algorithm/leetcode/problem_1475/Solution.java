package algorithm.leetcode.problem_1475;

public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (top > -1 && prices[stack[top]] >= prices[i]) {
                ans[stack[top]] = prices[stack[top]] - prices[i];
                top -= 1;
            }
            stack[++top] = i;
        }
        while (top > -1) {
            ans[stack[top]] = prices[stack[top]];
            top -= 1;
        }
        return ans;
    }
}

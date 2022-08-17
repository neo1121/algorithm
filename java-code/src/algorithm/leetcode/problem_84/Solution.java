package algorithm.leetcode.problem_84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length];
        int top = -1;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[stack[top]] > heights[i]) {
                int h = heights[stack[top--]];
                while (top > -1 && heights[stack[top]] == h) {
                    top -= 1;
                }
                int l = top == -1 ? -1 : stack[top];
                int area = h * (i - l - 1);
                max = Math.max(area, max);
            }
            stack[++top] = i;
        }
        while (top > -1) {
            int h = heights[stack[top--]];
            while (top > -1 && heights[stack[top]] == h) {
                top -= 1;
            }
            int l = top == -1 ? -1 : stack[top];
            int area = h * (heights.length - l - 1);
            max = Math.max(area, max);
        }
        return max;
    }
}

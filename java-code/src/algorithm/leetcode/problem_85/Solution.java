package algorithm.leetcode.problem_85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, getMax(heights));
        }
        return ans;
    }

    static int getMax(int[] heights) {
        int[] indexStack = new int[heights.length];
        int top = -1;
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[indexStack[top]] > heights[i]) {
                int h = heights[indexStack[top--]];
                while (top > -1 && h == heights[indexStack[top]]) {
                    top -= 1;
                }
                int l = top > -1 ? indexStack[top] : -1;
                area = Math.max(area, h * (i - l - 1));
            }
            indexStack[++top] = i;
        }
        while (top > -1) {
            int h = heights[indexStack[top--]];
            while (top > -1 && h == heights[indexStack[top]]) {
                top -= 1;
            }
            int l = top > -1 ? indexStack[top] : -1;
            area = Math.max(area, h * (heights.length - l - 1));
        }
        return area;
    }
}

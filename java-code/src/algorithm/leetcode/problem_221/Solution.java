package algorithm.leetcode.problem_221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
                int w = i - l - 1;
                int len = Math.min(w, h);
                area = Math.max(area, len * len);
            }
            indexStack[++top] = i;
        }
        while (top > -1) {
            int h = heights[indexStack[top--]];
            while (top > -1 && h == heights[indexStack[top]]) {
                top -= 1;
            }
            int l = top > -1 ? indexStack[top] : -1;
            int w = heights.length - l - 1;
            int len = Math.min(w, h);
            area = Math.max(area, len * len);
        }
        return area;
    }
}

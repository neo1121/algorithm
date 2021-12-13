package algorithm.leetcode.problem_807;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        for (int i = 0; i < n; i++) {
            int[] tempRow = grid[i];
            int tempMax = tempRow[0];
            for (int j = 1; j < n; j++) {
                tempMax = Math.max(tempMax, tempRow[j]);
            }
            rowMax[i] = tempMax;
        }
        for (int i = 0; i < n; i++) {
            int tempMax = grid[0][i];
            for (int j = 1; j < n; j++) {
                tempMax = Math.max(tempMax, grid[j][i]);
            }
            colMax[i] = tempMax;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret += Math.min(colMax[j], rowMax[i]) - grid[i][j];
            }
        }
        return ret;
    }
}

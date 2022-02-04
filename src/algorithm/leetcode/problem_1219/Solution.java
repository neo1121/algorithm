package algorithm.leetcode.problem_1219;

public class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ret = Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        int ret = grid[i][j];
        grid[i][j] = 0;
        int t = dfs(grid, i - 1, j);
        t = Math.max(t, dfs(grid, i + 1, j));
        t = Math.max(t, dfs(grid, i, j - 1));
        t = Math.max(t, dfs(grid, i, j + 1));
        grid[i][j] = ret;
        return ret + t;
    }
}

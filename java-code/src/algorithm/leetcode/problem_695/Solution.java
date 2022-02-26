package algorithm.leetcode.problem_695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, infect(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int infect(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        ans += infect(grid, i - 1, j);
        ans += infect(grid, i + 1, j);
        ans += infect(grid, i, j - 1);
        ans += infect(grid, i, j + 1);
        return ans;
    }
}

package algorithm.leetcode.problem_1254;

public class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && infect(grid, i, j, m, n)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public boolean infect(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean ans1 = infect(grid, i - 1, j, m, n);
        boolean ans2 = infect(grid, i + 1, j, m, n);
        boolean ans3 = infect(grid, i, j - 1, m, n);
        boolean ans4 = infect(grid, i, j + 1, m, n);
        return ans1 && ans2 && ans3 && ans4;
    }
}

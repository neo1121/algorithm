package algorithm.leetcode.problem_1020;

public class Solution {
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int t = infect(grid, i, j, m, n);
                    if (t > 0) {
                        ans += t;
                    }
                }
            }
        }
        return ans;
    }

    public int infect(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return -1;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans1 = infect(grid, i - 1, j, m, n);
        int ans2 = infect(grid, i + 1, j, m, n);
        int ans3 = infect(grid, i, j - 1, m, n);
        int ans4 = infect(grid, i, j + 1, m, n);
        if (ans1 == -1 || ans2 == -1 || ans3 == -1 || ans4 == -1) {
            return -1;
        }
        return 1 + ans1 + ans2 + ans3 + ans4;
    }
}

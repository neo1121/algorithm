package algorithm.leetcode.problem_1905;

public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] != 0 && infect(grid1, grid2, i, j, m, n)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public boolean infect(int[][] grid1, int[][] grid2, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        boolean ans = grid1[i][j] == grid2[i][j];
        grid2[i][j] = 0;
        boolean ans1 = infect(grid1, grid2, i - 1, j, m, n);
        boolean ans2 = infect(grid1, grid2, i + 1, j, m, n);
        boolean ans3 = infect(grid1, grid2, i, j - 1, m, n);
        boolean ans4 = infect(grid1, grid2, i, j + 1, m, n);
        return ans && ans1 && ans2 && ans3 && ans4;
    }
}

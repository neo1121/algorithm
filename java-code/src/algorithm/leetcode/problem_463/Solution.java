package algorithm.leetcode.problem_463;

public class Solution {
    public int ans;

    public int islandPerimeter(int[][] grid) {
        ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    infect(grid, i, j);
                    return ans;
                }
            }
        }
        return ans;
    }

    public void infect(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            ans += 1;
            return;
        }
        if (grid[i][j] == 0) {
            ans += 1;
            return;
        }
        if (grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}

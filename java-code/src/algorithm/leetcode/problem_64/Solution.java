package algorithm.leetcode.problem_64;

public class Solution {
    // 暴力递归
//    public HashMap<Integer, Integer> map = new HashMap<>();
//
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        return process(grid, m, n, 0, 0);
//    }
//
//    public int process(int[][] grid, int m, int n, int x, int y) {
//        int hashKey = hash(x, y);
//        if (map.containsKey(hashKey)) {
//            return map.get(hashKey);
//        }
//        if (x < 0 || x >= m || y < 0 || y >= n) {
//            return Integer.MAX_VALUE;
//        }
//        if (x == m - 1 && y == n - 1) {
//            return grid[x][y];
//        }
//        int val = grid[x][y] + Math.min(process(grid, m, n, x + 1, y), process(grid, m, n, x, y + 1));
//        map.put(hashKey, val);
//        return val;
//    }
//
//    public int hash(int x, int y) {
//        return x * 1000 + y;
//    }

    // 动态规划
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + grid[0][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][0];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

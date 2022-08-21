package algorithm.leetcode.problem_931;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j];
                } else if (j == 0) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
                } else if (j == n - 1) {
                    dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]), dp[i - 1][j]) + matrix[i][j];
                }
                if (i == m - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}

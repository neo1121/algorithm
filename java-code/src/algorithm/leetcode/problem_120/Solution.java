package algorithm.leetcode.problem_120;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = row.get(0);
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + row.get(0);
                } else if (j == row.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + row.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + row.get(j);
                }
                if (i == triangle.size() - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}

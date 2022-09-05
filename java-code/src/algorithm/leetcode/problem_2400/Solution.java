package algorithm.leetcode.problem_2400;

public class Solution {
    long[][] dp;
    int base;

    public int numberOfWays(int startPos, int endPos, int k) {
        base = startPos - k;
        dp = new long[2 * k + 1][k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return (int) dfs(startPos, endPos, k);
    }

    public long dfs(int startPos, int endPos, int k) {
        if (dp[hash(startPos)][k] != -1) {
            return dp[hash(startPos)][k];
        }
        if (Math.abs(endPos - startPos) > k) {
            dp[hash(startPos)][k] = 0;
            return 0;
        }
        if (k == 1) {
            return Math.abs(endPos - startPos) == 1 ? 1 : 0;
        }
        long ans = 0;
        ans += dfs(startPos - 1, endPos, k - 1);
        ans += dfs(startPos + 1, endPos, k - 1);
        ans = ans % (int) (1e9 + 7);
        dp[hash(startPos)][k] = ans;
        return ans;
    }

    public int hash(int v) {
        return v - base;
    }
}

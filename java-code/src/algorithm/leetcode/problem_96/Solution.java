package algorithm.leetcode.problem_96;

public class Solution {
    public int numTrees(int n) {
        // dp[i] 表示 i 个节点可构成的二叉树数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 为左子树数量, dp[i - j - 1] 为右子树数量
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

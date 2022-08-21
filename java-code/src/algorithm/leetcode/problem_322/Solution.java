package algorithm.leetcode.problem_322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 到达每个金额的最少硬币数
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

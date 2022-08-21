package algorithm.leetcode.problem_983;

import java.util.Arrays;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        int[] freeDay = new int[]{1, 7, 30};
        for (int day = 1, i = 0; day < dp.length; day++) {
            if (day < days[i]) {
                // 不需要出门
                dp[day] = dp[day - 1];
                continue;
            } else {
                i += 1;
            }
            for (int j = 0; j < costs.length; j++) {
                if (day < freeDay[j]) {
                    dp[day] = Math.min(dp[day], costs[j]);
                    continue;
                }
                dp[day] = Math.min(dp[day], dp[day - freeDay[j]] + costs[j]);
            }
        }
        return dp[lastDay];
    }
}

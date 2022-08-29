package algorithm.leetcode.problem_494;

public class Solution {
    int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new int[nums.length][2010];
        return dfs(nums, target, 0, 0);
    }

    int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int t = (sum + 1000) % 2010;
        if (memo[index][t] > 0) {
            return memo[index][t];
        }
        if (memo[index][t] < 0) {
            return 0;
        }
        int ret = dfs(nums, target, index + 1, sum + nums[index])
                + dfs(nums, target, index + 1, sum - nums[index]);
        if (ret == 0) {
            memo[index][t] = -1;
            return 0;
        }
        memo[index][t] = ret;
        return ret;
    }
}

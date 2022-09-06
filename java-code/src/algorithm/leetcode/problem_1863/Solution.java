package algorithm.leetcode.problem_1863;

public class Solution {
    int ans;

    public int subsetXORSum(int[] nums) {
        ans = 0;
        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int index, int sum) {
        if (index == nums.length) {
            ans += sum;
            return;
        }
        dfs(nums, index + 1, sum);
        sum ^= nums[index];
        dfs(nums, index + 1, sum);
    }
}

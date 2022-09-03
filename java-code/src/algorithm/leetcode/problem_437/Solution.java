package algorithm.leetcode.problem_437;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private HashMap<Long, Integer> prefixSum;

    public int pathSum(TreeNode root, int targetSum) {
        prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return dfs(root, targetSum, 0);
    }

    public int dfs(TreeNode root, long targetSum, long preSum) {
        if (root == null) {
            return 0;
        }
        long curSum = preSum + root.val;
        int ans = prefixSum.getOrDefault(curSum - targetSum, 0);
        int cnt = prefixSum.getOrDefault(curSum, 0);
        prefixSum.put(curSum, cnt + 1);
        ans += dfs(root.left, targetSum, curSum);
        ans += dfs(root.right, targetSum, curSum);
        prefixSum.put(curSum, cnt);
        return ans;
    }
}

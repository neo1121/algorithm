package algorithm.leetcode.problem_112;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int diff = targetSum - root.val;
        if (diff == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
    }
}

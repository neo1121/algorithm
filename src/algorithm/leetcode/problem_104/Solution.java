package algorithm.leetcode.problem_104;

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
    public int maxDepth(TreeNode root) {
        return process(root);
    }

    public int process(TreeNode root) {
        if (root == null)
            return 0;
        int left = process(root.left);
        int right = process(root.right);

        return Math.max(left, right) + 1;
    }
}

package algorithm.leetcode.problem_543;

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
    public int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        this.ans = 0;
        dfs(root);
        return this.ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left + right > this.ans) {
            this.ans = left + right;
        }
        return 1 + Math.max(left, right);
    }
}

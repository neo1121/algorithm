package algorithm.leetcode.problem_226;

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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        invert(left);
        invert(right);
        node.left = right;
        node.right = left;
    }
}

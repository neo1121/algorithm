package algorithm.leetcode.problem_100;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q != null) && p.val != q.val) return false;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        if (p == null && q == null) return true;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}

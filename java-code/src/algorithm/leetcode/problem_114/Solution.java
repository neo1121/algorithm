package algorithm.leetcode.problem_114;

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
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                cur = cur.right;
                continue;
            }
            cur.left = null;
            TreeNode rightestOnLeft = left;
            while (rightestOnLeft.right != null) {
                rightestOnLeft = rightestOnLeft.right;
            }
            rightestOnLeft.right = cur.right;
            cur.right = left;
            cur = cur.right;
        }
    }
}

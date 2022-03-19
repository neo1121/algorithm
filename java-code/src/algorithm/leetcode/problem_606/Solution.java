package algorithm.leetcode.problem_606;

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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        process(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    public void process(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append("(").append(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right != null) {
            sb.append("()");
        } else {
            process(left, sb);
        }
        process(right, sb);
        sb.append(")");
    }
}

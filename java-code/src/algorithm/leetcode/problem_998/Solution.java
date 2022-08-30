package algorithm.leetcode.problem_998;

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // 1. val > root.val -> 新节点作为 root, 旧节点作为左节点
        // 2. val < root.val -> root 往右节点移动, 若为空则添加新节点
        TreeNode pre = null;
        TreeNode node = root;
        while (node.right != null && val < node.val) {
            pre = node;
            node = node.right;
        }
        if (val < node.val) {
            node.right = new TreeNode(val);
            return root;
        }
        if (node == root) {
            return new TreeNode(val, root, null);
        }
        pre.right = new TreeNode(val, node, null);
        return root;
    }
}

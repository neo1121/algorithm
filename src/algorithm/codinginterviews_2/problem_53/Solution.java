package algorithm.codinginterviews_2.problem_53;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            return getLeftmost(p.right);
        } else {
            TreeNode father = null;
            while (root != p) {
                if (root.val > p.val) {
                    father = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return father;
        }
    }

    public TreeNode getLeftmost(TreeNode node) {
        if (node == null) return null;
        TreeNode ret = node;
        while (ret.left != null) {
            ret = ret.left;
        }
        return ret;
    }
}

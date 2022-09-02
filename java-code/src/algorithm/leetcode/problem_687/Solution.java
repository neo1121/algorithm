package algorithm.leetcode.problem_687;

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
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    // 求节点往下走 (只有左边或右边) 的最长路径的长度
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = dfs(root.left);
        // 节点左边最长路径长度
        int leftPath = 0;
        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        int right = dfs(root.right);
        // 节点右边最长路径长度
        int rightPath = 0;
        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }
        // 对每个节点更新最长路径 (含左右两边) 的长度
        ans = Math.max(ans, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}

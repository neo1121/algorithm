package algorithm.leetcode.problem_662;

import java.util.LinkedList;
import java.util.Queue;

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
    public int widthOfBinaryTree(TreeNode root) {
        root.val = 1;

        TreeNode first = null;
        TreeNode end = root;
        TreeNode nextEnd = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int n = node.val;
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left != null) {
                left.val = 2 * n;
                nextEnd = left;
                queue.add(left);
            }
            if (right != null) {
                right.val = 2 * n + 1;
                nextEnd = right;
                queue.add(right);
            }

            if (first == null) {
                first = node;
            }

            if (node == end) {
                ans = Math.max(ans, n - first.val + 1);
                end = nextEnd;
                nextEnd = null;
                first = null;
            }
        }

        return ans;
    }
}

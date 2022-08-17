package algorithm.leetcode.problem_1302;

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
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        TreeNode end = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            if (left != null) {
                nextEnd = left;
                queue.add(left);
            }
            if (right != null) {
                nextEnd = right;
                queue.add(right);
            }
            if (left == null && right == null) {
                ans += cur.val;
            }
            if (nextEnd != null && cur == end) {
                ans = 0;
                end = nextEnd;
                nextEnd = null;
            }
        }
        return ans;
    }
}

package algorithm.leetcode.problem_98;

import java.util.Stack;

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
    public boolean isValidBST(TreeNode root) {
        long preVal = Long.MIN_VALUE;
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (preVal > root.val)
                        return false;
                    preVal = root.val;
                    root = root.right;
                }
            }
        }
        return true;
    }

    static class Type {
        boolean valid;
        long max;
        long min;

        public Type(boolean valid, long max, long min) {
            this.valid = valid;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST2(TreeNode root) {
        return process(root).valid;
    }

    public Type process(TreeNode root) {
        if (root == null)
            return new Type(true, Long.MIN_VALUE, Long.MAX_VALUE);
        Type left = process(root.left);
        Type right = process(root.right);

        boolean valid = left.valid && right.valid && left.max < root.val && root.val < right.min;
        long min = Math.min(root.val, left.min);
        long max = Math.max(root.val, right.max);
        return new Type(valid, max, min);
    }

}

package algorithm.leetcode.problem_107;

import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {
                nextEnd = node.left;
                queue.add(node.left);
            }
            if (node.right != null) {
                nextEnd = node.right;
                queue.add(node.right);
            }
            if (node == curEnd) {
                curEnd = nextEnd;
                nextEnd = null;
                stack.push(temp);
                temp = new ArrayList<>();
            }
        }
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }
}

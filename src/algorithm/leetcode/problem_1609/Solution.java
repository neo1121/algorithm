package algorithm.leetcode.problem_1609;

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
    public boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 != 1) {
            return false;
        }
        int level = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            if (!isValid(cur.val, level)) {
                return false;
            }
            if (cur.left != null) {
                nextEnd = cur.left;
                nodes.add(cur.left);
            }
            if (cur.right != null) {
                nextEnd = cur.right;
                nodes.add(cur.right);
            }
            if (cur == curEnd) {
                curEnd = nextEnd;
                nextEnd = null;
                level += 1;
                continue;
            }
            TreeNode next = nodes.peek();
            if (next == null) {
                break;
            }
            if (level % 2 == 0) {
                if (next.val <= cur.val) {
                    return false;
                }
            } else {
                if (next.val >= cur.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int val, int level) {
        boolean isEvenLevel = level % 2 == 0;
        boolean isEvenVal = val % 2 == 0;
        return isEvenLevel != isEvenVal;
    }

}

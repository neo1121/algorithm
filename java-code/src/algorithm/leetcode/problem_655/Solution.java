package algorithm.leetcode.problem_655;

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
    static String[][] res;
    static int height;

    public List<List<String>> printTree(TreeNode root) {
        height = calcHeight(root) - 1;
        int m = height + 1;
        int n = (int) (Math.pow(2, height + 1) - 1);
        res = new String[m][n];
        make(root, 0, (n - 1) / 2);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (res[i][j] == null) {
                    row.add("");
                } else {
                    row.add(res[i][j]);
                }
            }
            ans.add(row);
        }
        return ans;
    }

    void make(TreeNode root, int r, int c) {
        if (root == null) {
            return;
        }
        res[r][c] = Integer.toString(root.val);
        make(root.left, r + 1, (int) (c - Math.pow(2, height - r - 1)));
        make(root.right, r + 1, (int) (c + Math.pow(2, height - r - 1)));
    }

    int calcHeight(TreeNode root) {
        int height = 0;
        TreeNode end = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                nextEnd = left;
                queue.add(left);
            }
            if (right != null) {
                nextEnd = right;
                queue.add(right);
            }
            if (node == end) {
                height += 1;
                end = nextEnd;
                nextEnd = null;
            }
        }
        return height;
    }
}

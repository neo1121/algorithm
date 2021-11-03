package algorithm.leetcode.problem_144;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        process(root,ret);
        return ret;
    }

    public void process(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        process(root.left, list);
        process(root.right, list);
    }
}

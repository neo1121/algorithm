package algorithm.leetcode.problem_113;

import java.util.ArrayList;
import java.util.LinkedList;
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
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root, targetSum);
        return ans;
    }

    public void process(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        int diff = targetSum - root.val;
        path.add(root.val);
        if (diff == 0 && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        } else {
            process(root.left, diff);
            process(root.right, diff);
        }
        path.remove(path.size() - 1);
    }
}

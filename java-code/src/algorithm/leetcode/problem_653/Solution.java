package algorithm.leetcode.problem_653;

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
    public boolean findTarget(TreeNode root, int k) {
        if (k < -20000 || k > 20000) {
            return false;
        }
        int[] set = new int[20001];
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, int[] set, int k) {
        if (root == null) {
            return false;
        }
        if (set[hash(root.val)] > 0) {
            return true;
        }
        int need = hash(k - root.val);
        if (need >= 0 && need <= 20000) {
            set[need] += 1;
        }
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public int hash(int num) {
        return num + 10000;
    }
}

package algorithm.leetcode.problem_2096;

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
    StringBuilder path;

    public boolean dfs(TreeNode root, int aim) {
        if (root.val == aim) {
            return true;
        }
        path.append('L');
        if (root.left != null && dfs(root.left, aim)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if (root.right != null && dfs(root.right, aim)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        path = new StringBuilder();
        dfs(root, startValue);
        String start = path.toString();
        path.delete(0, path.length());
        dfs(root, destValue);
        String dest = path.toString();
        int len = Math.min(start.length(), dest.length());
        int index = len;
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) != dest.charAt(i)) {
                index = i;
                break;
            }
        }
        start = start.substring(index);
        dest = dest.substring(index);
        return "U".repeat(start.length()) + dest;
    }
}

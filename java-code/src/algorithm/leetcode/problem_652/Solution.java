package algorithm.leetcode.problem_652;

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
    static class Pair {
        int idx;
        TreeNode node;

        public Pair(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }


    int idx;
    HashSet<TreeNode> ans;
    HashMap<String, Pair> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        idx = 0;
        ans = new HashSet<>();
        map = new HashMap<>();
        dfs(root);
        return new ArrayList<>(ans);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String s = Arrays.toString(new int[]{root.val, dfs(root.left), dfs(root.right)});
        Pair pair = map.get(s);
        if (pair != null) {
            ans.add(pair.node);
            return pair.idx;
        }
        map.put(s, new Pair(++idx, root));
        return idx;
    }
}

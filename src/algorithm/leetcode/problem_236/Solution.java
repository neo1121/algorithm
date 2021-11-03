package algorithm.leetcode.problem_236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                fatherMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                fatherMap.put(node.right, node);
                stack.push(node.right);
            }
        }
        HashSet<TreeNode> pSet = new HashSet<>();
        TreeNode cur = p;
        while (cur != fatherMap.get(cur)) {
            pSet.add(cur);
            cur = fatherMap.get(cur);
        }
        pSet.add(root);
        cur = q;
        while (cur != fatherMap.get(cur)) {
            if (pSet.contains(cur))
                return cur;
            cur = fatherMap.get(cur);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        // if "p" and "q" are the same side of "root", one of them will be the another one's ancestor.
        // one of "left" and "right" will be null and the another will be "p" or "q".

        // if "p" and "q" are the both sides of "root",
        // one of "left" and "right" will be "p" and the another will be "q".
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        // both "left" and "right" are not null, which means "p" and "q" are on both sides of "root".
        // so the lowest common ancestor will be root.
        if (left != null && right != null)
            return root;

        // one of "left" and "right" is not null, which means "p" and "q" are on same side of "root".
        // so the lowest common ancestor will be the not null one.
        return left != null ? left : right;
    }

}

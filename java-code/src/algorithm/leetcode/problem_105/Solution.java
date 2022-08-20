package algorithm.leetcode.problem_105;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    static TreeNode build(int[] preorder, int[] inorder, int ps, int is, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        for (; i < is + len; i++) {
            if (inorder[i] == preorder[ps]) {
                break;
            }
        }
        root.left = build(
                preorder,
                inorder,
                ps + 1,
                is,
                i - is
        );
        root.right = build(
                preorder,
                inorder,
                ps + 1 + i - is,
                i + 1,
                len - i + is - 1
        );
        return root;
    }
}

package algorithm.leetcode.problem_654;


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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    static TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int maxIndex = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, l, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, r);
        return root;
    }

    static int findMax(int[] nums, int l, int r) {
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }
}

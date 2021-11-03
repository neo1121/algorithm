package algorithm.leetcode.problem_297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serProcess(root);
    }

    public String serProcess(TreeNode root) {
        String str = "";
        if (root == null) {
            str += "#_";
        } else {
            str += root.val + "_";
            str += serProcess(root.left);
            str += serProcess(root.right);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public static int i = 0;

    public TreeNode deserialize(String data) {
        i = 0;
        String[] chars = data.split("[_]");
        return process(chars);
    }

    public TreeNode process(String[] chars) {
        if (chars[i].equals("#")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(chars[i++]));
        root.left = process(chars);
        root.right = process(chars);
        return root;
    }
}

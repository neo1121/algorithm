package algorithm.leetcode.problem_2196;

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

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childSet = new HashSet<>();
        for (int[] description : descriptions) {
            int p = description[0];
            int c = description[1];
            boolean isLeft = description[2] == 1;
            TreeNode pNode = map.get(p);
            if (pNode == null) {
                pNode = new TreeNode(p);
                map.put(p, pNode);
            }
            TreeNode cNode = map.get(c);
            if (cNode == null) {
                cNode = new TreeNode(c);
                map.put(c, cNode);
            }
            childSet.add(c);
            if (isLeft) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
        }
        for (Integer integer : childSet) {
            map.remove(integer);
        }
        TreeNode ans = null;
        for (TreeNode value : map.values()) {
            ans = value;
        }
        return ans;
    }

}

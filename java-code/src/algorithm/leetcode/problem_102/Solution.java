package algorithm.leetcode.problem_102;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        int curLevel = 1;
        List<Integer> temp = new ArrayList<>();
        levelMap.put(root, 1);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int curNodeLevel = levelMap.get(node);
            if (curNodeLevel != curLevel) {
                ret.add(temp);
                temp.clear();
                curLevel++;
            }
            temp.add(node.val);
            if (node.left != null) {
                levelMap.put(node.left, curNodeLevel + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                levelMap.put(node.right, curNodeLevel + 1);
                queue.add(node.right);
            }
        }
        ret.add(temp);
        return ret;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            if(node.left!=null){
                nextEnd = node.left;
                queue.add(node.left);
            }
            if(node.right!=null) {
                nextEnd = node.right;
                queue.add(node.right);
            }
            if(node == curEnd){
                ret.add(temp);
                temp = new ArrayList<>();
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return ret;
    }
}

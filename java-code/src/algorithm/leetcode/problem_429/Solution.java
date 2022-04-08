package algorithm.leetcode.problem_429;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            List<Node> t = new ArrayList<>();
            nodes.forEach(n -> {
                t.addAll(n.children);
                vals.add(n.val);
            });
            ans.add(vals);
            nodes = t;
        }
        return ans;
    }
}

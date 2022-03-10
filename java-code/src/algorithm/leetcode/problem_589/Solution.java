package algorithm.leetcode.problem_589;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            ans.add(cur.val);
            List<Node> children = cur.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return ans;
    }
}

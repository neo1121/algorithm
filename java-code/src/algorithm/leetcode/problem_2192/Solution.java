package algorithm.leetcode.problem_2192;

import java.util.*;

public class Solution {
    public static class Node {
        public int val;
        public int in;
        public List<Integer> nexts;
        public TreeSet<Integer> fathers;

        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.nexts = new ArrayList<>();
            this.fathers = new TreeSet<>();
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new Node(i));
        }
        for (int[] edge : edges) {
            Node fromNode = nodeMap.get(edge[0]);
            Node toNode = nodeMap.get(edge[1]);
            fromNode.nexts.add(toNode.val);
            toNode.in += 1;
        }
        HashSet<Integer> usedNode = new HashSet<>();
        while (usedNode.size() < n) {
            Stack<Node> stack = new Stack<>();
            for (Node node : nodeMap.values()) {
                if (!usedNode.contains(node.val) && node.in == 0) {
                    usedNode.add(node.val);
                    stack.add(node);
                }
            }
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                for (Integer next : node.nexts) {
                    Node nextNode = nodeMap.get(next);
                    nextNode.fathers.add(node.val);
                    nextNode.fathers.addAll(node.fathers);
                    nextNode.in -= 1;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(nodeMap.get(i).fathers));
        }
        return ans;
    }
}

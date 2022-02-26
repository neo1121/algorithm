package algorithm.leetcode.problem_851;

import java.util.*;

public class Solution {
    public static class Node {
        public int val;
        public int in;
        public ArrayList<Node> nexts;

        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.nexts = new ArrayList<>();
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, Node> graph = new HashMap<>();
        for (int[] nodes : richer) {
            int fromVal = nodes[0];
            int toVal = nodes[1];
            Node from = graph.get(fromVal);
            Node to = graph.get(toVal);
            if (from == null) {
                from = new Node(fromVal);
                graph.put(fromVal, from);
            }
            if (to == null) {
                to = new Node(toVal);
                graph.put(toVal, to);
            }
            from.nexts.add(to);
            to.in += 1;
        }
        // 遍历过的入度为 0 的节点
        HashSet<Node> usedNode = new HashSet<>();
        // 入度为 0 的节点
        Queue<Node> queue = new LinkedList<>();
        // 遍历入度为 0 的节点
        for (Node node : graph.values()) {
            if (node.in == 0 && !usedNode.contains(node)) {
                usedNode.add(node);
                queue.add(node);
            }
        }
        int[] ret = new int[quiet.length];
        Arrays.fill(ret, -1);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (ret[cur.val] == -1) {
                ret[cur.val] = cur.val;
            }
            for (Node next : cur.nexts) {
                if (ret[next.val] == -1) {
                    ret[next.val] = quiet[ret[cur.val]] < quiet[next.val] ? ret[cur.val] : next.val;
                } else {
                    ret[next.val] = quiet[ret[cur.val]] < quiet[ret[next.val]] ? ret[cur.val] : ret[next.val];
                }
                next.in -= 1;
            }
            // 遍历入度为 0 的节点
            for (Node node : graph.values()) {
                if (!usedNode.contains(node) && node.in == 0) {
                    usedNode.add(node);
                    queue.add(node);
                }
            }
        }
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == -1) {
                ret[i] = i;
            }
        }
        return ret;
    }
}

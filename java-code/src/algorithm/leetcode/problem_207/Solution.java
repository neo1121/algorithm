package algorithm.leetcode.problem_207;

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            for (int i = 0; i < prerequisite.length; i++) {
                Node node = nodeMap.get(prerequisite[i]);
                if (node == null) {
                    node = new Node(prerequisite[i]);
                    nodeMap.put(prerequisite[i], node);
                }
                node.in += i == 0 ? 1 : 0;
                if (i == 1) {
                    node.nexts.add(nodeMap.get(prerequisite[0]));
                }
            }
        }
        Queue<Node> queue = new LinkedList<>();
        for (Node node : nodeMap.values()) {
            if (node.in == 0) {
                queue.add(node);
            }
        }
        int ans = queue.size();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node next : node.nexts) {
                next.in -= 1;
                if (next.in == 0) {
                    queue.add(next);
                    ans += 1;
                }
            }
        }
        return ans == nodeMap.size();
    }
}

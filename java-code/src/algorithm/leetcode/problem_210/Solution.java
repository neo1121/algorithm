package algorithm.leetcode.problem_210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = i;
            }
            return ans;
        }
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new Node(i));
        }
        for (int[] prerequisite : prerequisites) {
            for (int i = 0; i < prerequisite.length; i++) {
                Node node = nodeMap.get(prerequisite[i]);
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
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ans[index++] = node.val;
            for (Node next : node.nexts) {
                next.in -= 1;
                if (next.in == 0) {
                    queue.add(next);
                }
            }
        }
        return index == numCourses ? ans : new int[]{};
    }
}

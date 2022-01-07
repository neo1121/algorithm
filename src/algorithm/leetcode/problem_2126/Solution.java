package algorithm.leetcode.problem_2126;

import java.util.PriorityQueue;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int asteroid : asteroids) {
            minHeap.add(asteroid);
        }
        long totalMass = mass;
        while (!minHeap.isEmpty()) {
            if (totalMass < minHeap.peek()) {
                return false;
            }
            totalMass += minHeap.poll();
        }
        return true;
    }
}

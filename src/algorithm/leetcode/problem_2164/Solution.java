package algorithm.leetcode.problem_2164;

import java.util.PriorityQueue;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? minHeap.poll() : maxHeap.poll();
        }
        return nums;
    }
}

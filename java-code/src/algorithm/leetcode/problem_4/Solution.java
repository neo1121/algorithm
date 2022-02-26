package algorithm.leetcode.problem_4;

import java.util.PriorityQueue;

public class Solution {
    public PriorityQueue<Double> maxHeap;
    public PriorityQueue<Double> minHeap;
    public int maxSize;
    public int minSize;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (int) (b - a));
        maxSize = 0;
        minSize = 0;
        for (int num : nums1) {
            add(num);
            revise();
        }
        for (int num : nums2) {
            add(num);
            revise();
        }
        if (maxSize == minSize) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxSize > minSize) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public void add(double num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            maxSize += 1;
        } else {
            minHeap.add(num);
            minSize += 1;
        }
    }

    public void revise() {
        while (maxSize - minSize >= 2) {
            minHeap.add(maxHeap.poll());
            maxSize -= 1;
            minSize += 1;
        }
        while (minSize - maxSize >= 2) {
            maxHeap.add(minHeap.poll());
            minSize -= 1;
            maxSize += 1;
        }
    }
}

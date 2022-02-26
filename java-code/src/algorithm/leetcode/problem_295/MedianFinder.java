package algorithm.leetcode.problem_295;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        maxHeap = new PriorityQueue<>(((o1, o2) -> o1 - o2));
    }

    public void addNum(int num) {
        Integer cur = maxHeap.peek();
        if (cur == null || num <= cur) maxHeap.add(num);
        else minHeap.add(num);
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return maxHeap.peek() + (minHeap.peek() - maxHeap.peek()) / 2.0;
        else return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}

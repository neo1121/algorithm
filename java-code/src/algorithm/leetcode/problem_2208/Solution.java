package algorithm.leetcode.problem_2208;

import java.util.PriorityQueue;

public class Solution {
    public int halveArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> b - a > 0 ? 1 : -1);
        double sum = 0;
        for (int num : nums) {
            maxHeap.add((double) num);
            sum += num / 2.0;
        }
        int ans = 0;
        while (sum > 0) {
            double t = maxHeap.poll();
            while (t >= maxHeap.peek() && sum > 0) {
                t /= 2;
                sum -= t;
                ans += 1;
            }
            maxHeap.add(t);
            System.out.println(sum);
        }
        return ans;
    }
}

package algorithm.leetcode.problem_769;

import java.util.Stack;

public class Solution {
    // 可以同 768 做法
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int max = Math.max(stack.peek(), arr[i]);
            while (stack.size() > 0 && stack.peek() > arr[i]) {
                stack.pop();
            }
            stack.push(max);
        }
        return stack.size();
    }
}

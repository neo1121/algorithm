package algorithm.leetcode.problem_496;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] nextGreater = new int[10001];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            // 单调递减栈
//            while (stack.size() > 0 && stack.peek() < nums2[i]) {
//                stack.pop();
//            }
//            if (stack.size() > 0) {
//                nextGreater[nums2[i]] = stack.peek();
//            } else {
//                nextGreater[nums2[i]] = -1;
//            }
//            stack.push(nums2[i]);
//        }

        // 自实现栈做法
        int[] nextGreater = new int[10001];
        int[] stack = new int[nums2.length];
        int top = -1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (top > -1 && stack[top] < nums2[i]) {
                top -= 1;
            }
            if (top > -1) {
                nextGreater[nums2[i]] = stack[top];
            } else {
                nextGreater[nums2[i]] = -1;
            }
            stack[++top] = nums2[i];
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater[nums1[i]];
        }
        return ans;
    }
}

package algorithm.leetcode.problem_946;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0, j = 0; i < n && j < n; ) {
            stack[++top] = pushed[i++];
            while (top > -1 && stack[top] == popped[j]) {
                top -= 1;
                j += 1;
            }
        }
        return top == -1;
    }
}

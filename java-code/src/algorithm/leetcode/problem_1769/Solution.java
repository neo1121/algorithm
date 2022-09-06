package algorithm.leetcode.problem_1769;

public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int leftCnt = 0;
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i - 1) == '1') {
                leftCnt += 1;
            }
            left[i] = left[i - 1] + leftCnt;
        }

        int[] right = new int[n];
        int rightCnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (boxes.charAt(i + 1) == '1') {
                rightCnt += 1;
            }
            right[i] = right[i + 1] + rightCnt;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }
}

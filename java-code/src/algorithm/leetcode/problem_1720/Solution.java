package algorithm.leetcode.problem_1720;

public class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}

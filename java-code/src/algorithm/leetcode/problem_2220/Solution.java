package algorithm.leetcode.problem_2220;

public class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int ans = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                ans += 1;
            }
            num /= 2;
        }
        return ans;
    }
}

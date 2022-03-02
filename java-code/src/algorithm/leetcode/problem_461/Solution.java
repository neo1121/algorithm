package algorithm.leetcode.problem_461;

public class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int ans = 0;
        while (x > 0) {
            if ((x & 1) == 1) {
                ans += 1;
            }
            x = x >> 1;
        }
        return ans;
    }
}

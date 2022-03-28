package algorithm.leetcode.problem_693;

public class Solution {
    // 模拟
    public boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n > 0) {
            int cur = n % 2;
            if (cur == pre) {
                return false;
            }
            pre = cur;
            n /= 2;
        }
        return true;
    }

    // 位运算
    public boolean hasAlternatingBits2(int n) {
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }
}

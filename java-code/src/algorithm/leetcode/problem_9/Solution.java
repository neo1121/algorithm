package algorithm.leetcode.problem_9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int bitCount = 0;
        int num = x;
        while (x > 0) {
            bitCount += 1;
            x /= 10;
        }
        return num == process(num, bitCount);
    }

    // 考虑反转后溢出 int 的情况, 所以此处用 long
    public long process(int num, int bit) {
        if (num / 10 == 0) {
            return num;
        }
        int n = num % 10;
        return (long) (n * Math.pow(10, bit - 1) + process(num / 10, bit - 1));
    }
}

package algorithm.leetcode.problem_7;

public class Solution {
    public int reverse(int x) {
        int bitCount = 0;
        long num = Math.abs((long) x);
        while (num > 0) {
            bitCount += 1;
            num /= 10;
        }
        long ret = process(Math.abs(x), bitCount);
        if (x < 0) {
            ret = -ret;
        }
        if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ret;
    }

    // 考虑反转后溢出 int 的情况, 所以此处用 long
    public long process(long num, int bit) {
        if (num / 10 == 0) {
            return num;
        }
        int n = (int) (num % 10);
        return (long) (n * Math.pow(10, bit - 1) + process(num / 10, bit - 1));
    }
}

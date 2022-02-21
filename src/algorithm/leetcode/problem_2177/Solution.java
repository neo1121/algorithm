package algorithm.leetcode.problem_2177;

public class Solution {
    public long[] sumOfThree(long num) {
        if ((num + 3) % 3 != 0) {
            return new long[0];
        }
        long max = (num + 3) / 3;
        return new long[]{max - 2, max - 1, max};
    }
}

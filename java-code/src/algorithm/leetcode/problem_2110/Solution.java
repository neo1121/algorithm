package algorithm.leetcode.problem_2110;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        long ret = 0;
        long count = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count += 1;
            } else {
                ret += (1 + count) * count / 2;
                count = 1;
            }
        }
        if (count > 1) {
            ret += (1 + count) * count / 2;
        }
        return ret;
    }
}

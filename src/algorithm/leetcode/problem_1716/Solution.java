package algorithm.leetcode.problem_1716;

public class Solution {
    public static int totalMoney(int n) {
        int cur = 0;
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            int day = i % 7;
            if (day == 1) {
                ret += ++cur;
            } else if (day == 0) {
                ret += cur + 6;
            } else {
                ret += cur + day - 1;
            }
        }
        return ret;
    }
}

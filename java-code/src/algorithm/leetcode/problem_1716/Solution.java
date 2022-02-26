package algorithm.leetcode.problem_1716;

public class Solution {
    public int totalMoney(int n) {
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

    public int totalMoney2(int n) {
        int week = n / 7;
        int day = n % 7;
        int ret = week >= 1 ? 28 : 0;
        for (int i = 1; i < week; i++) {
            ret += 7 * i + 28;
        }
        for (int i = 0; i < day; i++) {
            ret += week + 1 + i;
        }
        return ret;
    }
}

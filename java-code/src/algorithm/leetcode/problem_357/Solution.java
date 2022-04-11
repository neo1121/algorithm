package algorithm.leetcode.problem_357;

public class Solution {
    public int ans;

    public int countNumbersWithUniqueDigits(int n) {
        process(0, 0, n);
        return this.ans + 1;
    }

    public void process(int r, int size, int n) {
        if (size == n) {
            return;
        }
        int i = size == 0 ? 1 : 0;
        for (; i < 10; i++) {
            int t = 1 << i;
            if ((r & t) == 0) {
                this.ans += 1;
                process(r | t, size + 1, n);
            }
        }
    }
}

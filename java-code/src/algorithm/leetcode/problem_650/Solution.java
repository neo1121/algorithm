package algorithm.leetcode.problem_650;

public class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int i = n - 1;
        for (; i > 1; i--) {
            if (n % i == 0)
                break;
        }
        if (i == 1) return n;
        return minSteps(i) + n / i;
    }
}

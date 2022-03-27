package algorithm.leetcode.problem_2028;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        sum = (m + n) * mean - sum;
        int rest = sum % n;
        sum /= n;
        if (sum <= 0 || sum > 6 || (sum == 6 && rest > 0)) {
            return new int[]{};
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            if (rest > 0) {
                if (rest + sum <= 6) {
                    ans[i] += rest;
                } else {
                    ans[i] = 6;
                }
                rest -= 6 - sum;
            }
        }
        return ans;
    }
}

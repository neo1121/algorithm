package algorithm.leetcode.problem_762;

public class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (; left <= right; left++) {
            if (isPrimeNumber(Integer.bitCount(left))) {
                ans += 1;
            }
        }
        return ans;
    }

    public boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = num + 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

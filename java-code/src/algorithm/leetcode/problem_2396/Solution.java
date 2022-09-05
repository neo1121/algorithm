package algorithm.leetcode.problem_2396;

public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = n - 2; i >= 2; i--) {
            if (!isPalindrom(n, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrom(int n, int i) {
        String s = Integer.toString(n, i);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
}

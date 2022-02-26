package algorithm.leetcode.problem_1446;

public class Solution {
    public int maxPower(String s) {
        int cur = 1;
        int max = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                max = Math.max(++cur, max);
            } else {
                cur = 1;
            }
        }
        return max;
    }
}

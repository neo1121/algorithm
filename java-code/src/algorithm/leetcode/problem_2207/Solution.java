package algorithm.leetcode.problem_2207;

public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] chars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int[] secChar = new int[chars.length];
        int[] r = new int[2];
        if (chars[chars.length - 1] == patternChars[1]) {
            secChar[chars.length - 1] = 1;
            r[1] = 1;
        } else if (chars[chars.length - 1] == patternChars[0]) {
            r[0] = 1;
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            secChar[i] = secChar[i + 1];
            if (chars[i] == patternChars[1]) {
                secChar[i] += 1;
                r[1] += 1;
            } else if (chars[i] == patternChars[0]) {
                r[0] += 1;
            }
        }
        if (patternChars[0] == patternChars[1]) {
            return (long) (r[1] + 1) * r[1] / 2;
        }
        long ans = Math.max(r[0], r[1]);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == patternChars[0]) {
                ans += secChar[i];
            }
        }
        return ans;
    }
}

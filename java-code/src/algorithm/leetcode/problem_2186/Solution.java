package algorithm.leetcode.problem_2186;

import java.util.Arrays;

public class Solution {
    public int minSteps(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (sChars[i] == tChars[j]) {
                i += 1;
                j += 1;
                continue;
            }
            ans += 1;
            if (sChars[i] < tChars[j]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return ans + s.length() - i + t.length() - j;
    }
}

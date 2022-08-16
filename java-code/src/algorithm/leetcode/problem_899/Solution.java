package algorithm.leetcode.problem_899;

import java.util.Arrays;

public class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k > 1) {
            Arrays.sort(chars);
            return new String(chars);
        }
        int start = 0;
        for (int i = 1; i < chars.length; i++) {
            start = cmp(chars, start, i);
        }
        return s.substring(start, chars.length) + s.substring(0, start);
    }

    static int cmp(char[] chars, int i, int j) {
        for (int k = 0; k < chars.length; k++) {
            if (chars[(i + k) % chars.length] == chars[(j + k) % chars.length]) {
                continue;
            } else if (chars[(i + k) % chars.length] < chars[(j + k) % chars.length]) {
                return i;
            } else {
                return j;
            }
        }
        return i;
    }
}

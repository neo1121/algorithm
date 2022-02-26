package algorithm.leetcode.problem_28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] next = getNextArr(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public int[] getNextArr(String s) {
        if (s.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int p = 0;
        while (i < s.length()) {
            if (s.charAt(i - 1) == s.charAt(p)) {
                next[i++] = ++p;
            } else if (p > 0) {
                p = next[p];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}

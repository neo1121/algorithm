package algorithm.leetcode.problem_28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int len = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (i + len > haystack.length()) {
                return -1;
            }
            String substring = haystack.substring(i, i + len);
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

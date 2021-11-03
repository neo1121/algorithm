package algorithm.leetcode.problem_1392;

public class Solution {
    public String longestPrefix(String s) {
        String ret = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            String prefix = s.substring(0, i + 1);
            String suffix = s.substring(s.length() - 1 - i);
            if (prefix.equals(suffix)) ret = ret.length() > prefix.length() ? ret : prefix;
        }
        return ret;
    }
}

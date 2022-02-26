package algorithm.leetcode.problem_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String sortest = strs[0];
        for (String str : strs) {
            sortest = sortest.length() < str.length() ? sortest : str;
        }
        char[] chars = sortest.toCharArray();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            boolean identical = true;
            for (String str : strs) {
                if (str.charAt(i) != chars[i]) {
                    identical = false;
                    break;
                }
            }
            if (!identical) break;
            else ret.append(chars[i]);
        }
        return ret.toString();
    }
}

package algorithm.leetcode.problem_709;

public class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                chars[i] = (char) (ch - 'A' + 'a');
            }
        }
        return new String(chars);
    }
}

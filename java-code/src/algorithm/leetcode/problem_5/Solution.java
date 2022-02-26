package algorithm.leetcode.problem_5;

public class Solution {
    public String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                String temp = s.substring(j, j + i);
                if (isPalindrome(temp)) {
                    return temp;
                }
            }
        }
        return s.substring(0, 1);
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) == s.charAt(r--)) {
                continue;
            }
            return false;
        }
        return true;
    }
}

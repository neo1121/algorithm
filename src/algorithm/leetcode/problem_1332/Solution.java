package algorithm.leetcode.problem_1332;

public class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i < j ? 2 : 1;
    }
}

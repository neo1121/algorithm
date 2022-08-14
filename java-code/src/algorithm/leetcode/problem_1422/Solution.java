package algorithm.leetcode.problem_1422;

public class Solution {
    public int maxScore(String s) {
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                temp += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                temp -= 1;
            } else {
                temp += 1;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}

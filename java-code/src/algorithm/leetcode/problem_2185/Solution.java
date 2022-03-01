package algorithm.leetcode.problem_2185;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i < word.length() && j < pref.length()) {
                if (word.charAt(i) == pref.charAt(j)) {
                    i += 1;
                    j += 1;
                } else {
                    break;
                }
            }
            if (j == pref.length()) {
                ans += 1;
            }
        }
        return ans;
    }
}

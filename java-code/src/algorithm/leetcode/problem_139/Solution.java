package algorithm.leetcode.problem_139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int i = Integer.MAX_VALUE;
        // 找到字典中最短的单词长度
        for (String word : wordDict) {
            i = Math.min(i, word.length());
        }
        if (i > n) {
            // 字典中最短的单词比目标字符串长
            return false;
        }
        // dp[i] 表示能否拼接出字符串中长度为 i 的子串
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (; i <= n; i++) {
            for (String word : wordDict) {
                if (dp[i]) {
                    break;
                }
                if (i < word.length()) {
                    continue;
                }
                dp[i] = dp[i - word.length()] && s.startsWith(word, i - word.length());
            }
        }
        return dp[n];
    }
}

package algorithm.leetcode.problem_1592;

public class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");

        int cnt = text.length();
        for (String word : words) {
            cnt -= word.length();
        }

        StringBuilder ans = new StringBuilder();
        if (words.length > 1) {
            int avg = cnt / (words.length - 1);
            for (int i = 0; i < words.length - 1; i++) {
                ans.append(words[i]);
                for (int j = 0; j < avg; j++) {
                    ans.append(' ');
                }
                cnt -= avg;
            }
        }

        ans.append(words[words.length - 1]);

        for (int j = 0; j < cnt; j++) {
            ans.append(' ');
        }

        return ans.toString();
    }
}

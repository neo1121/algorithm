package algorithm.leetcode.problem_2000;

public class Solution {
    public String reversePrefix(String word, char ch) {
        int index = 0;
        StringBuilder pre = new StringBuilder();
        String after;
        for (; index < word.length(); index++) {
            if (word.charAt(index) == ch) break;
        }
        if (index == word.length()) return word;
        for (int i = index; i >= 0; i--) {
            pre.append(word.charAt(i));
        }
        after = word.substring(index + 1);
        pre.append(after);
        return pre.toString();
    }
}

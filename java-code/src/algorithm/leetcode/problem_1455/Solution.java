package algorithm.leetcode.problem_1455;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < searchWord.length()) {
                continue;
            }
            if (!words[i].substring(0, searchWord.length()).equals(searchWord)) {
                continue;
            }
            return i + 1;
        }
        return -1;
    }
}

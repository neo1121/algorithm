package algorithm.leetcode.problem_2108;

public class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (getPalindromic(word).equals(word)) {
                return word;
            }
        }
        return "";
    }

    public String getPalindromic(String word) {
        if (word.length() == 0) {
            return "";
        }
        char first = word.charAt(0);
        return getPalindromic(word.substring(1)) + first;
    }
}

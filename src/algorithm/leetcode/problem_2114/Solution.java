package algorithm.leetcode.problem_2114;

public class Solution {
    public int mostWordsFound(String[] sentences) {
        int ret = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            ret = Math.max(ret, words.length);
        }
        return ret;
    }
}

package algorithm.leetcode.problem_1816;

public class Solution {
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(strings[i]);
            if (i != k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

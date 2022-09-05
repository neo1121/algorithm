package algorithm.leetcode.problem_1689;

public class Solution {
    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        int max = 0;
        for (char aChar : chars) {
            int cur = aChar - '0';
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}

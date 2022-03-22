package algorithm.leetcode.problem_2038;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int aCount = 0;
        int bCount = 0;
        char[] chars = colors.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == chars[i] && chars[i] == chars[i + 1]) {
                if (chars[i] == 'A') {
                    aCount += 1;
                } else {
                    bCount += 1;
                }
            }
        }
        return aCount > bCount;
    }
}

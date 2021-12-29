package algorithm.leetcode.problem_2120;

public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int[] temp = startPos.clone();
            for (int j = i; j < s.length(); j++) {
                if (!isOk(temp, s.charAt(j), n)) {
                    ret[i] = j - i;
                    break;
                } else {
                    if (j == s.length() - 1) {
                        ret[i] = s.length() - i;
                    }
                }
            }
        }
        return ret;
    }

    public boolean isOk(int[] startPos, char op, int limit) {
        boolean ret = false;
        switch (op) {
            case 'R':
                ret = ++startPos[1] < limit;
                break;
            case 'L':
                ret = --startPos[1] >= 0;
                break;
            case 'U':
                ret = --startPos[0] >= 0;
                break;
            case 'D':
                ret = ++startPos[0] < limit;
                break;
        }
        return ret;
    }
}

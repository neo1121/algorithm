package algorithm.leetcode.problem_2109;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ret = new StringBuilder();
        ret.append(s, 0, spaces[0]);
        ret.append(" ");
        if (spaces.length == 1) {
            ret.append(s.substring(spaces[0]));
            return ret.toString();
        }
        for (int i = 0; i < spaces.length; i++) {
            if (i == spaces.length - 1) {
                ret.append(s.substring(spaces[i]));
            } else {
                ret.append(s, spaces[i], spaces[i + 1]);
                ret.append(" ");
            }
        }
        return ret.toString();
    }
}

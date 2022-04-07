package algorithm.leetcode.problem_796;

public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s += s;
        for (int i = 0; i < goal.length(); i++) {
            if (s.charAt(i) == goal.charAt(0) && s.substring(i, i + goal.length()).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}

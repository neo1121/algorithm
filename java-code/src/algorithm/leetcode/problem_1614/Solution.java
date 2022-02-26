package algorithm.leetcode.problem_1614;

public class Solution {
    public int maxDepth(String s) {
        int level = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                level += 1;
            } else if (s.charAt(i) == ')' && level > 0) {
                ret = Math.max(level, ret);
                level -= 1;
            }
        }
        return ret;
    }
}

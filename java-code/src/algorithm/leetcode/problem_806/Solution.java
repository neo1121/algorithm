package algorithm.leetcode.problem_806;

public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int lastWidth = 0;
        for (int i = 0; i < s.length(); i++) {
            int curWidth = widths[s.charAt(i) - 'a'];
            if (lastWidth + curWidth > 100) {
                line += 1;
                lastWidth = curWidth;
            } else {
                lastWidth += curWidth;
            }
        }
        return new int[]{line, lastWidth};
    }
}

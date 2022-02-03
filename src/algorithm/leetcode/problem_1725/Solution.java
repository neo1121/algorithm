package algorithm.leetcode.problem_1725;

public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int count = 0;
        for (int[] rectangle : rectangles) {
            int index = Math.min(rectangle[0], rectangle[1]);
            if (index > max) {
                max = index;
                count = 1;
            } else if (index == max) {
                count += 1;
            }
        }
        return count;
    }
}

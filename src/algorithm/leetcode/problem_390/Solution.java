package algorithm.leetcode.problem_390;

public class Solution {
    public int lastRemaining(int n) {
        int min = 1;
        int max = n;
        int round = 1;
        int step = 1;
        while (min != max) {
            step *= 2;
            if (round % 2 == 1) {
                if ((max - min) % step == 0) {
                    max -= step / 2;
                }
                min += step / 2;
            } else {
                if ((max - min) % step == 0) {
                    min += step / 2;
                }
                max -= step / 2;
            }
            round += 1;
        }
        return max;
    }
}

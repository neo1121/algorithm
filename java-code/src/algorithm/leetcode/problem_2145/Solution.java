package algorithm.leetcode.problem_2145;

public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int ret = 0;
        for (int i = lower; i <= upper; i++) {
            int temp = i;
            boolean f = false;
            int max = i;
            for (int j = 0; j < differences.length; j++) {
                temp += differences[j];
                max = Math.max(temp, max);
                if (temp > upper || temp < lower) {
                    break;
                }
                if (j == differences.length - 1) {
                    ret += 1;
                    f = true;
                }
            }
            if (f) {
                ret += upper - max;
                break;
            }
        }
        return ret;
    }
}
